package com.example.hackathon.presentation.prizeresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.R
import com.example.hackathon.databinding.FragmentSelectAwardTypeBinding
import com.example.hackathon.presentation.model.Prize
import com.example.hackathon.presentation.model.PrizeResult

class FragmentSelectAwardType : Fragment() {

    private var _binding: FragmentSelectAwardTypeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PrizeResultViewModel
    private lateinit var adapter: AwardTypeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectAwardTypeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[PrizeResultViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.awardResults.observe(viewLifecycleOwner) { awardResults ->
            adapter.submitList(awardResults)
        }

        viewModel.fetchAwardResults("4567") // Group code를 전달
    }

    private fun setupRecyclerView() {
        adapter = AwardTypeAdapter { prizeResult ->
            viewModel.selectPrizeResult(prizeResult)
            parentFragmentManager.beginTransaction()
                .replace(R.id.layout_activity_prize_result, PrizeAwardFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerAwardTypeList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@FragmentSelectAwardType.adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


