package com.example.hackathon.data

class UserRepository {
    fun signup(
        email: String,
        name: String,
        password: String,
        passwordCheck: String,
    ): Result<Unit> = runCatching { if (password != passwordCheck) throw Error("아이디와 비밀번호가 일치하지 않아요!") }

    fun login(
        email: String,
        password: String,
    ): Result<Unit> = runCatching { }
}
