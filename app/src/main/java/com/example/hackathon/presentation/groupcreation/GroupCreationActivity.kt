package com.example.hackathon.presentation.groupcreation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityGroupCreationBinding
import com.example.hackathon.presentation.groupdetail.GroupDetailActivity
import com.example.hackathon.presentation.groupdetail.GroupDetailWatingFragment
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
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = PrizeCreationAdapter()
        binding.recyclerGroupCreationPrize.layoutManager = LinearLayoutManager(this)
        binding.recyclerGroupCreationPrize.adapter = adapter

        // 어댑터가 비었을 경우 기본 항목 보장
        adapter.ensureAtLeastOneItem()
    }

    private fun setupListeners() {
        // 시상 항목 추가
        binding.btnGroupCreationAddPrize.setOnClickListener {
            viewModel.addPrize()
        }

        // 그룹 생성
        binding.btnGroupCreationDone.setOnClickListener {
            val title = binding.etGroupCreationRoomName.text.toString()
            if (title.isBlank()) {
                Toast.makeText(this, "방 이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            val prizes = viewModel.getPrizes()
            if (prizes.isEmpty()) {
                Toast.makeText(this, "최소 하나의 시상 항목을 추가해주세요.", Toast.LENGTH_SHORT).show()
            }
            viewModel.createGroup(title, prizes)
        }
    }

    private fun observeViewModel() {
        viewModel.prizes.observe(this) { prizes ->
            adapter.updatePrizes(prizes)
        }

        viewModel.groupCreationState.observe(this) { state ->
            when (state) {
                GroupCreationViewModel.GroupCreationState.Success -> {
                    //Toast.makeText(this, "그룹이 성공적으로 생성되었습니다!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, GroupDetailActivity::class.java)
                    startActivity(intent)
                }
                is GroupCreationViewModel.GroupCreationState.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
                GroupCreationViewModel.GroupCreationState.Loading -> {
                    //Toast.makeText(this, "그룹 생성 중입니다...", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
