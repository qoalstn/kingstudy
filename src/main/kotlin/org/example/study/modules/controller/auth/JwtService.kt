package org.example.study.modules.controller.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.example.study.dao.ManagerEntity
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey


@Component
class JwtService {
var key: SecretKey? = Jwts.SIG.HS256.key().build()

    fun generateToken(manager: ManagerEntity): String {
        return Jwts.builder()
            .claim("roles",manager.roles)
            .claim("email",manager.email)
            .subject(manager.id.toString())  // 사용자 이름을 subject로 설정
            .issuedAt(Date())  // 발급일 설정
            .expiration(Date(System.currentTimeMillis() + 86400000))  // 만료일 설정 (1일)
            .signWith(key)
            .compact()  // JWT 토큰 생성
    }

    // JWT 토큰 유효성 검사
    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)  // JWT 파싱 및 검증
            true
        } catch (e: Exception) {
            false
        }
    }

    // JWT에서 사용자 정보 추출
    fun extractUsername(token: String): String {
        return parseClaims(token).subject
    }

    // JWT에서 Claims(사용자 정보) 추출
    private fun parseClaims(token: String): Claims {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload()
    }
}