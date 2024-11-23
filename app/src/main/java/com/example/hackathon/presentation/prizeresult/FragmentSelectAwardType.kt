package com.example.hackathon.presentation.prizeresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.data.GroupRepository
import com.example.hackathon.databinding.FragmentSelectAwardTypeBinding

class FragmentSelectAwardType : Fragment() {

    private var _binding: FragmentSelectAwardTypeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: PrizeResultAdapter
    private val repository = GroupRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectAwardTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadAwardResults()
    }

    private fun setupRecyclerView() {
        adapter = PrizeResultAdapter()
        binding.recyclerAwardTypeList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@FragmentSelectAwardType.adapter
        }
    }

    private fun loadAwardResults() {
        // GroupRepository를 통해 데이터 로드
        val result = repository.getAwardResults("4567")
        result.onSuccess { prizeResults ->
            adapter.updateItems(prizeResults)
        }.onFailure {
            // 실패 처리
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
