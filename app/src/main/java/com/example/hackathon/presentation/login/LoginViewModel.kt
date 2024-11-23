package com.example.hackathon.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email : StateFlow<String> = _email;

    private val _password = MutableStateFlow("")
    val password : StateFlow<String> = _password;

    // 로그인 상태 관리
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun updateEmail(input : String) {
        _email.value = input
    }

    fun updatePassword(input : String) {
        _password.value = input
    }

    // 로그인 처리 로직
    fun login() {
        if (_email.value.isEmpty() || _password.value.isEmpty()) {
            _loginState.value = LoginState.Error("이메일과 비밀번호를 입력하세요.")
            return
        }

        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                // 예시: 네트워크 요청 (Repository 호출)
                val isSuccess = mockLoginApi(_email.value, _password.value)
                if (isSuccess) {
                    _loginState.value = LoginState.Success("로그인 성공!")
                } else {
                    _loginState.value = LoginState.Error("로그인 실패: 잘못된 이메일/비밀번호.")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("오류 발생: ${e.message}")
            }
        }
    }

    // Mock API (실제 네트워크 호출 대체)
    private suspend fun mockLoginApi(email: String, password: String): Boolean {
        return email == "test@example.com" && password == "123456"
    }

    // 로그인 상태 표현
    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val message: String) : LoginState()
        data class Error(val error: String) : LoginState()
    }
}