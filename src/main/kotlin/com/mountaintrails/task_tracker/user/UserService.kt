package com.mountaintrails.task_tracker.user

import com.mountaintrails.task_tracker.exceptions.UserAlreadyExistsException
import org.springframework.stereotype.Service

interface UserService {
    // register a new user; sign up flow
    fun registerUser(userRequest: UserRequest): UserResponse

    // sign in flow
    fun signInUser(username: String, email: String, passwordHash: String)
}

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(userRequest: UserRequest): UserResponse {
        // check if the username or password has been taken
        if (userRepository.existsByEmail(userRequest.email) || userRepository.existsByUsername(userRequest.username)) {
            throw UserAlreadyExistsException("User already exists")
        }

        var user = userRepository.save(
                Users(
                    username = userRequest.username,
                    email = userRequest.email,
                    passwordHash = userRequest.passwordHash
                )
        )

        return user.toResponse()
    }

    override fun signInUser(username: String, email: String, passwordHash: String) {
        TODO("Not yet implemented")
    }

}