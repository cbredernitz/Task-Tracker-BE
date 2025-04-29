package com.mountaintrails.task_tracker.user.controller

import com.mountaintrails.task_tracker.user.model.UserRequest
import com.mountaintrails.task_tracker.user.model.UserResponse
import com.mountaintrails.task_tracker.user.model.Users
import com.mountaintrails.task_tracker.user.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

interface UserController {
    fun registerUser(userRequest: UserRequest): Users
}

@Controller
@RequestMapping("/api/v1/user")
class UserControllerImpl(
    private val userService: UserService
): UserController {

    @PostMapping("/registerUser")
    override fun registerUser(userRequest: UserRequest): Users {
        return userService.registerUser(userRequest);
    }
}