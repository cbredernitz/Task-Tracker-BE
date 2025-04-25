package com.mountaintrails.task_tracker.user.service

import com.mountaintrails.task_tracker.user.model.UserRequest
import com.mountaintrails.task_tracker.user.model.Users
import com.mountaintrails.task_tracker.user.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

interface UserService {
    // register a new user; sign up flow
    fun registerUser(userRequest: UserRequest): Users

    // sign in flow
    fun signInUser(username: String, email: String, passwordHash: String)
}

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(userRequest: UserRequest): Users {
        // check if the username or password has been taken
        if (userRepository.existsByEmail(userRequest.email) || userRepository.existsByUsername(userRequest.username)) {
            throw IllegalArgumentException("email or username already exists")
        }

        return userRepository.save(
            Users(
                username = userRequest.username,
                email = userRequest.email,
                passwordHash = userRequest.passwordHash
            )
        )
    }

    override fun signInUser(username: String, email: String, passwordHash: String) {
        TODO("Not yet implemented")
    }

}