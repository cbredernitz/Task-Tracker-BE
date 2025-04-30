package com.mountaintrails.task_tracker.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

interface UserController {
    fun registerUser(userRequest: UserRequest): UserResponse
}

@Controller
@RequestMapping("/api/v1/user")
class UserControllerImpl(
    private val userService: UserService
): UserController {

    @PostMapping("/registerUser")
    override fun registerUser(userRequest: UserRequest): UserResponse {
        return userService.registerUser(userRequest);
    }
}