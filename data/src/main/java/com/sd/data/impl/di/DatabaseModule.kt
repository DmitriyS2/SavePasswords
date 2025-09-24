package com.sd.data.impl.di

import com.sd.data.DataApi
import com.sd.data.UserApi
import com.sd.data.impl.DataImpl
import com.sd.data.impl.UserImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DatabaseModule {

    @Singleton
    @Binds
    fun bindData(impl: DataImpl): DataApi

    @Singleton
    @Binds
    fun bindUser(impl: UserImpl): UserApi
}