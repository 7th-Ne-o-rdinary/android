package com.example.hackathon.presentation.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        binding.btnLogin.setOnClickListener {
            // 회원가입 완료?
        }
    }
}
