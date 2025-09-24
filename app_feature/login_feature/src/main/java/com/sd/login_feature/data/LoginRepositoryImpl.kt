package com.sd.login_feature.data

import com.sd.data.UserApi
import javax.inject.Inject

internal class LoginRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
): LoginRepository {

    override suspend fun getPasswordByLogin(login: String): String? {
       return userApi.getPasswordByLogin(login)
    }
}