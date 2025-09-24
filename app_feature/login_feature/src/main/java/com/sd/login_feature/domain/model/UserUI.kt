package com.sd.login_feature.domain.model

import java.util.Date

data class UserUI(
    val id: Int = 0,
    val login: String = "",
    val password: String = "",
    val createdAt: Date? = null,
)
