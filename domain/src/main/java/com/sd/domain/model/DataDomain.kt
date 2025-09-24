package com.sd.domain.model

import java.util.Date

data class DataDomain(
    val id: Int = 0,
    val login: String = "",
    val name: String = "",
    val url: String = "",
    val password: String = "",
    val createdAt: Date? = null,
)
