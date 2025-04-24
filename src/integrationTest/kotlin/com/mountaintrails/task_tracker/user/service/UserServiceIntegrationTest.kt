package com.mountaintrails.task_tracker.user.service

import com.mountaintrails.task_tracker.user.model.User
import com.mountaintrails.task_tracker.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test

@SpringBootTest
class UserServiceIntegrationTest(
    @Autowired
    private val userRepository: UserRepository

) {

    @Test
    fun testRegisterUser() {
        //TODO:
    }

}