package com.example.hackathon.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val userRepository = UserRepository.getInstance()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun updateEmail(input: String) {
        _email.value = input
    }

    fun updatePassword(input: String) {
        _password.value = input
    }

    fun login() {
        if (_email.value.isEmpty() || _password.value.isEmpty()) {
            _loginState.value = LoginState.Error("이메일과 비밀번호를 입력하세요.")
            return
        }

        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            val result = userRepository.login(_email.value, _password.value)
            result
                .onSuccess {
                    _loginState.value = LoginState.Success("로그인 성공!")
                }.onFailure { error ->
                    Log.d("yenni", "error : $error")
                    _loginState.value = LoginState.Error(error.message ?: "로그인 실패")
                }
        }
    }

    sealed class LoginState {
        object Idle : LoginState()

        object Loading : LoginState()

        data class Success(
            val message: String,
        ) : LoginState()

        data class Error(
            val error: String,
        ) : LoginState()
    }
}
