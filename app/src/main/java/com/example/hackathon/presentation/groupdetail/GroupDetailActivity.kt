package com.example.hackathon.presentation.groupdetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityGroupDetailBinding
import com.example.hackathon.presentation.model.User

class GroupDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupDetailBinding
    private lateinit var adapter: GroupDetailAdapter
    private val viewModel: GroupDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView and ViewModel
        setupRecyclerView()
        observeViewModel()

        // Initialize button actions
        setupButtons()

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

    private fun setupButtons() {
        // Button to switch to QuizFragment
        binding.btnGroupDetailStartQuiz.setOnClickListener {
            showFragment(GroupDetailQuizFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
