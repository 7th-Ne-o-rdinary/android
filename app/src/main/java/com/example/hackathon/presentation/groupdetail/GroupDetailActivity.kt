package com.example.hackathon.presentation.groupdetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

        // Example to add a user manually for testing purposes
        viewModel.addUser(User(
            name = "로빈",
            id = "1"
        ))
        viewModel.addUser(User(
            name = "신구",
            id = "2"
        ))
        viewModel.addUser(User(
            name = "똘이",
            id = "2"
        ))
        viewModel.addUser(User(
            name = "상우",
            id = "2"
        ))
    }

    private fun setupRecyclerView() {
        adapter = GroupDetailAdapter()
        binding.recyclerGroupDetailWaitingUserList.apply {
            layoutManager = LinearLayoutManager(this@GroupDetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@GroupDetailActivity.adapter
        }
    }

    private fun observeViewModel() {
        viewModel.users.observe(this, Observer { users ->
            adapter.updateUsers(users)
        })
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
