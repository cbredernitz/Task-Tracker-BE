package com.mountaintrails.task_tracker.auth

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/auth")
class AuthenticationController(
    private val authenticationService: AuthenticationService
) {
    fun authenticate(@RequestBody authenticationRequest: AuthenticationRequest) {
        return authenticationService.authenticate(authenticationRequest)
    }
}