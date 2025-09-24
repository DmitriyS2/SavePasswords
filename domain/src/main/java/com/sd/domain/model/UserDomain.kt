package com.sd.domain.model

import java.util.Date

data class UserDomain(
    val id: Int = 0,
    val login: String = "",
    val password: String = "",
    val createdAt: Date? = null,
)
