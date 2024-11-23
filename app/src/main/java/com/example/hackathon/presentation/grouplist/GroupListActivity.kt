package com.example.hackathon.presentation.grouplist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackathon.databinding.ActivityGroupListBinding
import com.example.hackathon.presentation.groupcreation.GroupCreationActivity

class GroupListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding 초기화
        binding = ActivityGroupListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 시 GroupCreationActivity로 이동
        binding.mainGroupJoinGroupBtn.setOnClickListener {
            startActivity(
                Intent(this, GroupCreationActivity::class.java).apply {
                    // 필요 시 인텐트에 추가 데이터 전달
                }
            )
        }
    }
}
