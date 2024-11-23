package com.example.hackathon.data.dto.response

data class LoginResponse(
    val user: User,
    val token: Token,
)

data class User(
    val email: String,
    val name: String,
    val userRole: String,
)

data class Token(
    val accessToken: String,
    val refreshToken: String,
)
