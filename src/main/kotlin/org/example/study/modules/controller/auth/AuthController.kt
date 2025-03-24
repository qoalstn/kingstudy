package org.example.study.modules.controller.auth

import jakarta.servlet.http.HttpServletRequest
import org.example.study.modules.controller.auth.dto.ManagerLoginDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/auth")
class AuthController {
    @PostMapping("/login")
    fun login(@RequestBody userLogin: ManagerLoginDto, request: HttpServletRequest): ResponseEntity<String> {
        val user = userService.authenticate(userLogin.username, userLogin.password)
        if (user != null) {
            val session = request.session // 세션 생성
            session.setAttribute("user", user) // 세션에 사용자 저장

            val token = jwtService.generateToken(user) // JWT 생성
            return ResponseEntity.ok("Bearer $token") // JWT 반환
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials")
    }
}