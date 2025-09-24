package com.sd.login_feature.domain.usecase

internal interface GetPasswordByLoginUseCase {

    suspend operator fun invoke(login:String): String?
}