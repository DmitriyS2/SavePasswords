package com.sd.data

import com.sd.domain.model.UserDomain

interface UserApi {

    suspend fun insert(userDomain: UserDomain)
    suspend fun getPasswordByLogin(login: String): String?
    suspend fun getUserByLogin(login: String): UserDomain?
}