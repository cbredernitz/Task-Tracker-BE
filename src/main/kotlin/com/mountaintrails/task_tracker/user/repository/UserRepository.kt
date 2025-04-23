package com.mountaintrails.task_tracker.user.repository

import com.mountaintrails.task_tracker.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID> {

    fun findByEmail(email: String): Optional<User>
    fun findByUsername(username: String): Optional<User>

    // for validation in FE
    fun existsByEmail(email: String): Boolean
    fun existsByUsername(username: String): Boolean
}