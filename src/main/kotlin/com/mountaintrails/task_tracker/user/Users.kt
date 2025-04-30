package com.mountaintrails.task_tracker.user

import jakarta.persistence.*
import lombok.Builder
import java.util.UUID

@Entity
@Table(name = "users")
data class Users(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false, unique = true)
    val passwordHash: String
)

@Builder
data class UserRequest(
    val username: String,
    val email: String,
    val passwordHash: String
)

@Builder
data class UserResponse(
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String
)

fun Users.toResponse(): UserResponse {
    return UserResponse(
        id = this.id!!,
        username = this.username,
        email = this.email,
        passwordHash = this.passwordHash,
    )
}