package com.mountaintrails.task_tracker.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

interface UserController {
    fun registerUser(userRequest: UserRequest): UserResponse
}

@RestController
@RequestMapping("/api/v1/user")
class UserControllerImpl(
    private val userService: UserService
): UserController {

    @PostMapping("/registerUser")
    override fun registerUser(@RequestBody userRequest: UserRequest): UserResponse {
        return userService.registerUser(userRequest);
    }
}