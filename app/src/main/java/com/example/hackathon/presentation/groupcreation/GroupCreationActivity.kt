package com.example.hackathon.presentation.groupcreation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.databinding.ActivityGroupCreationBinding
import com.example.hackathon.presentation.model.PrizeCreation
import kotlinx.coroutines.launch

class GroupCreationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGroupCreationBinding
    private lateinit var adapter: PrizeCreationAdapter
    private val viewModel: GroupCreationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupCreationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupListeners()

        // Observe changes in the prize list
        viewModel.prizes.observe(this) { prizes ->
            adapter.updatePrizes(prizes)
        }
    }

    private fun setupRecyclerView() {
        adapter = PrizeCreationAdapter(mutableListOf())
        binding.recyclerGroupCreationPrize.layoutManager = LinearLayoutManager(this)
        binding.recyclerGroupCreationPrize.adapter = adapter
    }

    private fun setupListeners() {
        // Add Prize button
        binding.btnGroupCreationAddPrize.setOnClickListener {
            viewModel.addPrize(
                title = "",
                question = "",
                description = ""
            )
        }

        // Done button
        binding.btnGroupCreationDone.setOnClickListener {
            val prizes = viewModel.prizes.value ?: emptyList()

            if (prizes.isEmpty()) {
                Toast.makeText(this, "시상을 추가해주세요.", Toast.LENGTH_SHORT).show()
            }

            lifecycleScope.launch {
                // Simulate a repository call
                Toast.makeText(this@GroupCreationActivity, "방 생성 성공! ID: 12345", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
