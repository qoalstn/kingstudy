package org.example.study.interceptor

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@Component
class AuthInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = getBearerToken(request)

        if (token.isNullOrEmpty() || !isValidToken(token)) {
            response.status = HttpServletResponse.SC_UNAUTHORIZED
            response.writer.write("Unauthorized")
            return false
        }
        return true
    }

    private fun isValidToken(token: String): Boolean {
        return token == "valid_token" // 예시로 간단히 처리
    }

    private fun getBearerToken(request: HttpServletRequest): String? {
        // Authorization 헤더에서 Bearer 토큰을 추출
        val authorizationHeader = request.getHeader("Authorization") ?: return null

        // "Bearer "로 시작하는지 확인하고, Bearer 뒤의 토큰만 추출
        return if (authorizationHeader.startsWith("Bearer ")) {
            authorizationHeader.substring(7)  // "Bearer " 다음의 토큰 부분만 반환
        } else {
            null  // Bearer가 아닌 경우 null 반환
        }
    }
}
