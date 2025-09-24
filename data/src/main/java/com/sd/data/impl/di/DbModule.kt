package com.sd.data.impl.di

import android.content.Context
import androidx.room.Room
import com.sd.data.impl.dao.DataDao
import com.sd.data.impl.dao.UserDao
import com.sd.data.impl.db.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object DbModule {
    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, "app.db")
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDb: AppDb): UserDao = appDb.userDao()

    @Provides
    @Singleton
    fun provideDataDao(appDb: AppDb): DataDao = appDb.dataDao()
}