package com.example.hackathon.data

import com.example.hackathon.data.api.LoginService
import com.example.hackathon.data.api.TokenDataStore
import com.example.hackathon.data.dto.request.LoginRequest
import com.example.hackathon.data.dto.request.SignUpRequest

class UserRepository(
    private val loginService: LoginService,
    private val dataStore: TokenDataStore,
) {
    suspend fun signup(
        email: String,
        name: String,
        password: String,
        passwordCheck: String,
    ): Result<Unit> =
        runCatching {
            if (password != passwordCheck) throw Error("비밀번호와 비밀번호 확인 값이 같지 않아요!")
            val signUpRequest = SignUpRequest(email = email, name = name, password = password)
            loginService.signUp(signUpRequest)
        }

    suspend fun login(
        email: String,
        password: String,
    ): Result<Unit> =
        runCatching {
            val loginRequest = LoginRequest(email, password)
            val response = loginService.login(loginRequest)

            if (!response.isSuccessful) {
                throw Error("로그인에 실패했어요!")
            }

            val token = response.body()?.token?.accessToken ?: throw Error("로그인 토큰을 찾을 수 없어요!")
            dataStore.saveAccessToken(token)
        }

    companion object {
        private var instance: UserRepository? = null

        fun init(
            loginService: LoginService,
            dataStore: TokenDataStore,
        ) {
            instance = UserRepository(loginService, dataStore)
        }

        fun getInstance(): UserRepository = requireNotNull(instance)
    }
}
