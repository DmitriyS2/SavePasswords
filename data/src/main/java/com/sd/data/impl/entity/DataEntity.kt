package com.sd.data.impl.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sd.data.impl.db.MxTypeConverters
import com.sd.domain.model.DataDomain
import java.util.Date

@Entity
@TypeConverters(MxTypeConverters::class)
internal data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val login: String = "",
    val name: String = "",
    val url: String = "",
    val password: String = "",
    val createdAt: Date? = null,
)

internal fun DataEntity.toDomain(): DataDomain {
    return DataDomain(
        id = id,
        login = login,
        name = name,
        url = url,
        password = password,
        createdAt = createdAt,
    )
}

internal fun DataDomain.toEntity(): DataEntity {
    return DataEntity(
        id = id,
        login = login,
        name = name,
        url = url,
        password = password,
        createdAt = createdAt,
    )
}

internal fun List<DataEntity>.toDomains(): List<DataDomain> {
    return this.map { it.toDomain() }
}
