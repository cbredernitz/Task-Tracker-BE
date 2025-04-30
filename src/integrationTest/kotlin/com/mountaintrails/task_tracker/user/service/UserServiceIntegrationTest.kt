package com.mountaintrails.task_tracker.user.service

import com.mountaintrails.task_tracker.user.UserRequest
import com.mountaintrails.task_tracker.user.Users
import com.mountaintrails.task_tracker.user.UserRepository
import com.mountaintrails.task_tracker.user.UserService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class UserServiceIntegrationTest(
    @Autowired
    private val userRepository: UserRepository,

    @Autowired
    private val userService: UserService
) {

    @AfterEach
    fun tearDown() {
        userRepository.deleteAll()
    }

    @Test
    fun testRegisterUser_emailExists() {
        val user = Users(
            username = "testName",
            email = "trailblazer@mail.com",
            passwordHash = "bkjbawdUAGWdukbkadlbAdho8dhaowdblakwbdIbajbdAKJd"
        )

        userRepository.save(user)

        val request = UserRequest(
            username = "Billy Joel",
            email = "trailblazer@mail.com",
            passwordHash = "bkjbawdUAGWdukbkadlbAdho8dhaowdblakwbdIbajbdAKJd"
        )
        assertThrows<IllegalArgumentException> {
            userService.registerUser(request)
        }
    }

    @Test
    fun testRegisterUser_usernameExists() {
        val user = Users(
            username = "testName",
            email = "trailblazer@mail.com",
            passwordHash = "bkjbawdUAGWdukbkadlbAdho8dhaowdblakwbdIbajbdAKJd"
        )

        userRepository.save(user)

        val request = UserRequest(
            username = "testName",
            email = "newEmail@mail.com",
            passwordHash = "bkjbawdUAGWdukbkadlbAdho8dhaowdblakwbdIbajbdAKJd"
        )
        assertThrows<IllegalArgumentException> {
            userService.registerUser(request)
        }
    }

    @Test
    fun testRegisterUser_createsUser() {
        val request = UserRequest(
            username = "BillyJoel",
            email = "newEmail@mail.com",
            passwordHash = "bkjbawdUAGWdukbkadlbAdho8dhaowdblakwbdIbajbdAKJd"
        )

        val actual = userService.registerUser(request)

        val user = userRepository.findById(actual.id!!)

        assertEquals("BillyJoel", user.get().username)
        assertEquals("newEmail@mail.com", user.get().email)
    }
}