package com.sd.login_feature.data

internal interface LoginRepository {

    suspend fun getPasswordByLogin(login: String): String?
}