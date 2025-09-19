package com.sd.common.secret.impl.di

import com.sd.common.secret.PasswordProtect
import com.sd.common.secret.impl.PasswordProtectImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.crypto.Cipher
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import javax.crypto.SecretKeyFactory

@Module
@InstallIn(SingletonComponent::class)
internal object CipherModule {

    @Provides
    @Singleton
    fun provideCipher(): Cipher {
        return Cipher.getInstance("AES/GCM/NoPadding")
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal object SecretKeyFactoryModule {

    @Provides
    @Singleton
    fun provideSecretKeyFactory(): SecretKeyFactory{
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SecretModule {

    @Binds
    @Singleton
    abstract fun bindPasswordProtect(impl: PasswordProtectImpl): PasswordProtect
}