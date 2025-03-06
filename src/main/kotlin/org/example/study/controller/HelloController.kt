package org.example.study.controller

import org.example.study.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/api/hello")
    fun hello(): String {
        return "Hello, Kotlin + Spring Boot!"
    }

    @PostMapping("/api/user")
    fun createUser(@RequestBody user: User): String {
        return "User ${user.name} with age ${user.age} created!"
    }
}
