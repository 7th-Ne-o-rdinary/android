package com.example.hackathon.presentation.groupdetail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityGroupDetailBinding
import com.example.hackathon.presentation.model.GroupDetail
import com.example.hackathon.presentation.model.User

class GroupDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupDetailBinding
    private lateinit var adapter: GroupDetailAdapter
    private val viewModel: GroupDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("GroupDetailActivity", "onCreate called") // 추가된 로그
        binding = ActivityGroupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView and ViewModel
        setupRecyclerView()
        observeViewModel()
        val fragment_quiz = GroupDetailQuizFragment()

        // Initialize button actions
        val button = findViewById<AppCompatButton>(R.id.btn_group_detail_start_quiz);
        button.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_group_detail,fragment_quiz)
                .commit()
        }

        // Fetch participant list from ViewModel
        viewModel.fetchParticipantList("sampleCode")
    }

    private fun setupRecyclerView() {
        adapter = GroupDetailAdapter()
        binding.recyclerGroupDetailWaitingUserList.apply {
            layoutManager = LinearLayoutManager(this@GroupDetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@GroupDetailActivity.adapter
        }
    }

    private fun observeViewModel() {
        // Observe the users LiveData
        viewModel.users.observe(this) { users ->
            adapter.updateUsers(users)
        }
    }
}
