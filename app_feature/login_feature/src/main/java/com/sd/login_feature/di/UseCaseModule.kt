package com.sd.login_feature.di

import com.sd.login_feature.domain.usecase.GetPasswordByLoginUseCase
import com.sd.login_feature.domain.usecase.GetPasswordByLoginUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface UseCaseModule{

    @Binds
    @Singleton
    fun bindsGetPasswordByLogin(impl: GetPasswordByLoginUseCaseImpl): GetPasswordByLoginUseCase
}