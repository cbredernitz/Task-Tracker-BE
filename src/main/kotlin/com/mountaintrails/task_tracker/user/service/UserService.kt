package com.mountaintrails.task_tracker.user.service

import com.mountaintrails.task_tracker.user.repository.UserRepository
import org.springframework.stereotype.Service

interface UserService {
    // register a new user; sign up flow
    fun registerUser(username: String, email: String, passwordHash: String): Boolean

    // sign in flow
    fun signInUser(username: String, email: String, passwordHash: String)
}

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(username: String, email: String, passwordHash: String): Boolean {
        // check if the username or password has been taken

            // if it has been then throw exception that they are already in use

        // if not create new user and save. return the new user.
        TODO()
    }

    override fun signInUser(username: String, email: String, passwordHash: String) {
        TODO("Not yet implemented")
    }

}