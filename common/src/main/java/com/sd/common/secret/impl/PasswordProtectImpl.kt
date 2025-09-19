package com.sd.common.secret.impl

import android.util.Base64
import com.sd.common.secret.PasswordProtect
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject

internal class PasswordProtectImpl @Inject constructor(
    private val secretKeyFactory: SecretKeyFactory,
    private val cipher: Cipher,
): PasswordProtect {
    private val KEY_LENGTH = 256
    private val IV_LENGTH = 12
    private val TAG_LENGTH = 128
    private val ITERATIONS = 100000

    private fun deriveKeyFromMasterPassword(masterPasswordHash: String): SecretKey {
        val salt = masterPasswordHash.toByteArray(StandardCharsets.UTF_8)
        val spec = PBEKeySpec(
            "password_encryption_key".toCharArray(),
            salt,
            ITERATIONS,
            KEY_LENGTH
        )
        val tmp = secretKeyFactory.generateSecret(spec)
        return SecretKeySpec(tmp.encoded, "AES")
    }

    override fun encrypt(userPassword: String, masterPasswordHash: String): String? {
        return try {
            val iv = ByteArray(IV_LENGTH)
            SecureRandom().nextBytes(iv)

            val key = deriveKeyFromMasterPassword(masterPasswordHash)

            val parameterSpec = GCMParameterSpec(TAG_LENGTH, iv)
            cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec)

            val encrypted = cipher.doFinal(userPassword.toByteArray(StandardCharsets.UTF_8))
            val combined = iv + encrypted

            Base64.encodeToString(combined, Base64.NO_WRAP)
        } catch (e: Exception) {
            null
        }
    }

    override fun decrypt(encryptedPassword: String?, masterPasswordHash: String): String? {
        if (encryptedPassword == null) return null

        return try {
            val combined = Base64.decode(encryptedPassword, Base64.NO_WRAP)

            val iv = combined.copyOfRange(0, IV_LENGTH)
            val encrypted = combined.copyOfRange(IV_LENGTH, combined.size)

            val key = deriveKeyFromMasterPassword(masterPasswordHash)

            val parameterSpec = GCMParameterSpec(TAG_LENGTH, iv)
            cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec)

            String(cipher.doFinal(encrypted), StandardCharsets.UTF_8)
        } catch (e: Exception) {
            null
        }
    }
}