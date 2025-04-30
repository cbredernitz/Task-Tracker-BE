package com.mountaintrails.task_tracker.config

import com.mountaintrails.task_tracker.exceptions.UserAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(UserAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    fun handleUserAlreadyExists(ex: UserAlreadyExistsException): ErrorResponse {
        return ErrorResponse(message = ex.message ?: "User already exists.")
    }
}

data class ErrorResponse(val message: String)

