package com.sd.login_feature.domain.usecase

import com.sd.login_feature.data.LoginRepository
import javax.inject.Inject

internal class GetPasswordByLoginUseCaseImpl @Inject constructor(
    private val loginRepository: LoginRepository,
): GetPasswordByLoginUseCase {

    override suspend fun invoke(login: String): String? {
        return loginRepository.getPasswordByLogin(login)
    }
}