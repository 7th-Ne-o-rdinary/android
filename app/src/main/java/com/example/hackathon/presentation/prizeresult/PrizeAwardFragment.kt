package com.example.hackathon.presentation.prizeresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackathon.databinding.FragmentPrizeAwardBinding
import com.example.hackathon.presentation.model.PrizeResult

class PrizeAwardFragment : Fragment() {

    private var _binding: FragmentPrizeAwardBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PrizeResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrizeAwardBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[PrizeResultViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedPrizeResult.observe(viewLifecycleOwner) { result ->
            if (result != null) {
                binding.tvPrizeAwardName.text = result.user.name
                binding.tvPrizeAwardInfo1.text = result.prize.description
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


