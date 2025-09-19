package com.sd.common.secret

interface PasswordProtect {
    fun encrypt(userPassword: String, masterPasswordHash: String): String?
    fun decrypt(encryptedPassword: String?, masterPasswordHash: String): String?
}