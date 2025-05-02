package com.mountaintrails.task_tracker.auth

data class AuthenticationRequest(
    val email: String,
    val password: String
)

data class AuthenticatiionResponse(
    val accessToken: String,
    val refreshToken: String
)