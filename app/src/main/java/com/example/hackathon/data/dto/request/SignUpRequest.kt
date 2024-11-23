package com.example.hackathon.data.dto.request

data class SignUpRequest(
    val email: String,
    val name: String,
    val password: String,
    val passwordCheck: String,
)
