package com.sd.login_feature.di

import com.sd.login_feature.data.LoginRepository
import com.sd.login_feature.data.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsLoginRepository(impl: LoginRepositoryImpl): LoginRepository
}