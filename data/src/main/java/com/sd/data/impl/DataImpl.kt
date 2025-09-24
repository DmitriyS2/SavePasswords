package com.sd.data.impl

import com.sd.data.DataApi
import com.sd.data.impl.dao.DataDao
import com.sd.data.impl.entity.toDomain
import com.sd.data.impl.entity.toDomains
import com.sd.data.impl.entity.toEntity
import com.sd.domain.model.DataDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DataImpl @Inject constructor(
    private val dataDao: DataDao,
) : DataApi {

    override suspend fun insert(dataDomain: DataDomain) {
        dataDao.insert(dataDomain.toEntity())
    }

    override fun getAllDataByLogin(login: String): Flow<List<DataDomain>> {
        return dataDao.getAllDataByLogin(login).map { it.toDomains() }
    }

    override suspend fun getDataByName(name: String): DataDomain? {
        return dataDao.getDataByName(name)?.toDomain()
    }
}