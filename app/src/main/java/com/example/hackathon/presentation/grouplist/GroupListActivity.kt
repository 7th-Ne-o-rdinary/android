package com.example.hackathon.presentation.grouplist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityGroupListBinding
import com.example.hackathon.presentation.groupcreation.GroupCreationActivity

class GroupListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 시 GroupCreationActivity로 이동
        binding.mainGroupJoinGroupBtn.setOnClickListener {
            val intent = Intent(this, GroupCreationActivity::class.java)
            startActivity(intent)
        }
    }
}
