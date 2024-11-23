package com.example.hackathon.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        binding.tvLoginSignupBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java) // TODO: 이동할 액티비티를 설정
            startActivity(intent)
        }
    }
}
