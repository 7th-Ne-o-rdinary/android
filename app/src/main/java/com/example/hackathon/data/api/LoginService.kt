package com.example.hackathon.data.api

import com.example.hackathon.data.dto.request.LoginRequest
import com.example.hackathon.data.dto.request.SignUpRequest
import com.example.hackathon.data.dto.response.LoginResponse
import com.example.hackathon.data.dto.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest,
    ): Response<SignUpResponse>

    @POST("/api/v1/auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): Response<LoginResponse>
}
