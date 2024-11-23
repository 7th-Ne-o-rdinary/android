package com.example.hackathon.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    // 사용자 입력 상태
    private val _name = MutableStateFlow("")
    val name : StateFlow<String> get() = _name

    private val _email = MutableStateFlow("")
    val email : StateFlow<String> get() = _email

    private val _password = MutableStateFlow("")
    val password : StateFlow<String> get() = _password
    // 상태 관리
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _signUpResult = MutableStateFlow<Result<String>?>(null)
    val signUpResult: StateFlow<Result<String>?> get() = _signUpResult

    // 입력 값 업데이트 함수
    fun updateName(input: String) {
        _name.value = input
    }

    fun updateEmail(input: String) {
        _email.value = input
    }

    fun updatePassword(input: String) {
        _password.value = input
    }

    // 회원가입 실행
    fun signUp() {
        // 입력 값 유효성 검증
        if (!isInputValid()) {
            _signUpResult.value = Result.failure(Exception("입력값이 유효하지 않습니다."))
            return
        }

        // 로딩 상태 설정
        _isLoading.value = true

        // 네트워크 요청 실행
        viewModelScope.launch {
            try {
                val response = mockSignUpApi(
                    name = _name.value,
                    email = _email.value,
                    password = _password.value
                )
                _signUpResult.value = Result.success(response)
            } catch (e: Exception) {
                _signUpResult.value = Result.failure(e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    // 입력값 유효성 검증
    private fun isInputValid(): Boolean {
        return _name.value.isNotBlank() &&
                _email.value.contains("@") &&
                _password.value.length >= 6
    }

    // 모킹된 API 호출 함수 (실제 API 호출로 대체 가능)
    private suspend fun mockSignUpApi(name: String, email: String, password: String): String {
        // 실제 네트워크 요청으로 대체 가능
        return "회원가입 성공"
    }
}