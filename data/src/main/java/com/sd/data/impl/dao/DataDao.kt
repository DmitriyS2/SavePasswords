package com.sd.data.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sd.data.impl.entity.DataEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dataEntity: DataEntity)

    @Query("SELECT * FROM DataEntity WHERE login= :login")
    fun getAllDataByLogin(login: String): Flow<List<DataEntity>>

    @Query("SELECT * FROM DataEntity WHERE name = :name")
    suspend fun getDataByName(name:String): DataEntity?
}