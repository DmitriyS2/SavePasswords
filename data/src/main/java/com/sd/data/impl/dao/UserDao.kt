package com.sd.data.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sd.data.impl.entity.UserEntity

@Dao
internal interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: UserEntity)

    @Query("SELECT password FROM UserEntity WHERE login = :login")
    suspend fun getPasswordByLogin(login: String): String?

    @Query("SELECT * FROM UserEntity WHERE login = :login")
    suspend fun getUserByLogin(login: String): UserEntity?
}