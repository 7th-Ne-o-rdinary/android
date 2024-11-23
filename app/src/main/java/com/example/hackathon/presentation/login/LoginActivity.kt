package com.example.hackathon.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityLoginBinding
import com.example.hackathon.presentation.groupcreation.GroupCreationActivity
import com.example.hackathon.presentation.groupjoin.GroupJoinActivity
import com.example.hackathon.presentation.grouplist.GroupListActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        observeViewModel()
    }

    private fun setupListeners() {
        binding.etLoginEmail.addTextChangedListener { text ->
            viewModel.updateEmail(text.toString())
            validateFields()
        }

        binding.etLoginPassword.addTextChangedListener { text ->
            viewModel.updatePassword(text.toString())
            validateFields()
        }

        binding.btnLogin.setOnClickListener {
            viewModel.login()
        }

        binding.tvLoginSignupBtn.setOnClickListener {
            val intent = Intent(this, GroupCreationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateFields() {
        val isEmailFilled = binding.etLoginEmail.text?.isNotEmpty() == true
        val isPasswordFilled = binding.etLoginPassword.text?.isNotEmpty() == true

        binding.btnLogin.isEnabled = isEmailFilled && isPasswordFilled
        val textColor = if (isEmailFilled && isPasswordFilled) {
            getColor(R.color.black)
        } else {
            getColor(R.color.gray_300)
        }
        binding.btnLogin.setTextColor(textColor)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.loginState.collect { state ->
                when (state) {
                    is LoginViewModel.LoginState.Idle -> {
                        // Reset UI to idle state if needed
                    }
                    is LoginViewModel.LoginState.Loading -> {
                        //Toast.makeText(this@LoginActivity, "로그인 중...", Toast.LENGTH_SHORT).show()
                    }
                    is LoginViewModel.LoginState.Success -> {
                        //Toast.makeText(this@LoginActivity, state.message, Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity, GroupListActivity::class.java)
                        startActivity(intent)
                    }
                    is LoginViewModel.LoginState.Error -> {
                        Toast.makeText(this@LoginActivity, state.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
