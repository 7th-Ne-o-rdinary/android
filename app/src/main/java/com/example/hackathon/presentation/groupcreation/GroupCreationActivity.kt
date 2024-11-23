package com.example.hackathon.presentation.groupcreation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.databinding.ActivityGroupCreationBinding
import com.example.hackathon.presentation.model.PrizeCreation

class GroupCreationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupCreationBinding
    private val viewModel: GroupCreationViewModel by viewModels()
    private lateinit var adapter: PrizeCreationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupCreationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupListeners()

        // ViewModel의 데이터 변화 감지
        viewModel.prizes.observe(this) { prizes ->
            adapter.updatePrizes(prizes)
        }
    }

    private fun setupRecyclerView() {
        adapter = PrizeCreationAdapter()
        binding.recyclerGroupCreationPrize.layoutManager = LinearLayoutManager(this)
        binding.recyclerGroupCreationPrize.adapter = adapter

        // 어댑터가 비었을 경우 기본 항목 보장
        adapter.ensureAtLeastOneItem()
    }

    private fun setupListeners() {
        binding.btnGroupCreationAddPrize.setOnClickListener {
            viewModel.addPrize()
        }

        binding.btnGroupCreationDone.setOnClickListener {
            val prizes = viewModel.getPrizes()
            if (prizes.isNotEmpty()) {
                Toast.makeText(this, "시상식이 성공적으로 생성되었습니다!", Toast.LENGTH_SHORT).show()
                // 실제 API 요청 또는 로직 처리 추가
            } else {
                Toast.makeText(this, "최소 하나의 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
