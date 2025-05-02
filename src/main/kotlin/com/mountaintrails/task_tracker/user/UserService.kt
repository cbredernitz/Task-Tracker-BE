package com.mountaintrails.task_tracker.user

import com.mountaintrails.task_tracker.exceptions.UserAlreadyExistsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

interface UserService {
    // register a new user
    fun registerUser(userRequest: UserRequest): UserResponse
    // sign in flow
    fun signInUser(username: String, email: String, passwordHash: String)
    // update user
    fun updateUser();
}

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
): UserService {

    override fun registerUser(userRequest: UserRequest): UserResponse {
        // check if the username or password has been taken
        if (userRepository.existsByEmail(userRequest.email) || userRepository.existsByUsername(userRequest.username)) {
            throw UserAlreadyExistsException("User already exists")
        }

        // encrypt the password to database
        val passwordEncrypt = passwordEncoder.encode(userRequest.passwordHash)

        var user = userRepository.save(
                Users(
                    username = userRequest.username,
                    email = userRequest.email,
                    passwordHash = passwordEncrypt,
                    roles = Role.USER, // doing generic user on create. Will update with better in the future.
                    createdDate = LocalDateTime.now()
                )
        )

        return user.toResponse()
    }

    override fun signInUser(username: String, email: String, passwordHash: String) {
        TODO("Not yet implemented")
    }

    override fun updateUser() {
        // this will be used to update the password once it is wired up. Updated datetime will also be filled in.
        TODO("Not yet implemented")
    }

}