package com.mountaintrails.task_tracker.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<Users, UUID> {

    fun findByEmail(email: String): Optional<Users>
    fun findByUsername(username: String): Optional<Users>

    // for validation in FE
    fun existsByEmail(email: String): Boolean
    fun existsByUsername(username: String): Boolean
}