package com.sd.data.impl.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sd.data.impl.db.MxTypeConverters
import com.sd.domain.model.UserDomain
import java.util.Date

@Entity
@TypeConverters(MxTypeConverters::class)
internal data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val login: String = "",
    val password: String = "",
    val createdAt: Date? = null,
)

internal fun UserEntity.toDomain(): UserDomain {
    return UserDomain(
        id = id,
        login = login,
        password = password,
        createdAt = createdAt,
    )
}

internal fun UserDomain.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        login = login,
        password = password,
        createdAt = createdAt,
    )
}
