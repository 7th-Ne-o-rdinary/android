package com.example.hackathon.data.dto.response

sealed class SignUpResponse {
    data class Success(
        val email: String,
        val name: String,
        val userRole: String,
    ) : SignUpResponse()

    data class Error(
        val status: String,
        val message: String,
    ) : SignUpResponse()

    data class Conflict(
        val status: String,
        val message: String,
    ) : SignUpResponse()
}
