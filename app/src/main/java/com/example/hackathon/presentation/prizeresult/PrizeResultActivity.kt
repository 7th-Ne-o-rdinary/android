package com.example.hackathon.presentation.prizeresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackathon.R

class PrizeResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prize_result)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.layout_activity_prize_result, WaitResultFragment())
                .commit()
        }
    }
}
