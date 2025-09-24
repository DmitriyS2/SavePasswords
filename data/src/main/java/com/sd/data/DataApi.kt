package com.sd.data

import com.sd.domain.model.DataDomain
import kotlinx.coroutines.flow.Flow

interface DataApi {

    suspend fun insert(dataDomain: DataDomain)
    fun getAllDataByLogin(login: String): Flow<List<DataDomain>>
    suspend fun getDataByName(name:String): DataDomain?
}