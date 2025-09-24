package com.sd.data.impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sd.data.impl.dao.DataDao
import com.sd.data.impl.dao.UserDao
import com.sd.data.impl.entity.DataEntity
import com.sd.data.impl.entity.UserEntity

@Database(
    entities = [UserEntity::class, DataEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class AppDb : RoomDatabase() {
    abstract fun dataDao(): DataDao
    abstract fun userDao(): UserDao
}