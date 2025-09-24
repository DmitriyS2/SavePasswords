package com.sd.data.impl

import com.sd.data.UserApi
import com.sd.data.impl.dao.UserDao
import com.sd.data.impl.entity.toDomain
import com.sd.data.impl.entity.toEntity
import com.sd.domain.model.UserDomain
import javax.inject.Inject

internal class UserImpl @Inject constructor(
    private val userDao: UserDao,
): UserApi {

    override suspend fun insert(userDomain: UserDomain) {
        userDao.insert(userDomain.toEntity())
    }

    override suspend fun getPasswordByLogin(login: String): String? {
       return userDao.getPasswordByLogin(login)
    }

    override suspend fun getUserByLogin(login: String): UserDomain? {
        return userDao.getUserByLogin(login)?.toDomain()
    }
}