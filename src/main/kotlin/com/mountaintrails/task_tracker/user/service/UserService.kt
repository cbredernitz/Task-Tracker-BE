package com.mountaintrails.task_tracker.user.service

import com.mountaintrails.task_tracker.user.model.User
import com.mountaintrails.task_tracker.user.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

interface UserService {
    // register a new user; sign up flow
    fun registerUser(username: String, email: String, passwordHash: String): User

    // sign in flow
    fun signInUser(username: String, email: String, passwordHash: String)
}

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(username: String, email: String, passwordHash: String): User {
        // check if the username or password has been taken
        if (userRepository.existsByEmail(email)) {
            throw IllegalArgumentException("email already exists")
        }
            // if it has been then throw exception that they are already in use

        // if not create new user and save. return the new user.
        // this is for now
        return User(
            id = UUID.randomUUID(),
            username = "",
            email = "",
            passwordHash = ""
        )
    }

    override fun signInUser(username: String, email: String, passwordHash: String) {
        TODO("Not yet implemented")
    }

}