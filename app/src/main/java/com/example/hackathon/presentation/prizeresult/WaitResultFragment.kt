package com.example.hackathon.presentation.prizeresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackathon.R
import com.example.hackathon.databinding.FragmentWaitResultBinding

class WaitResultFragment : Fragment() {
    private var _binding: FragmentWaitResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PrizeResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWaitResultBinding.inflate(inflater, container, false)

        // ViewModel 연결
        viewModel = ViewModelProvider(this)[PrizeResultViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 버튼 클릭 이벤트
        binding.btnWaitResultCheckResult.setOnClickListener {
            val isCompleted = viewModel.isAwardCompleted("sampleCode") // 예시 코드 전달
            if (isCompleted) {
                // 결과 확인 가능 시 Fragment 변경
                parentFragmentManager.beginTransaction()
                    .replace(R.id.layout_activity_prize_result, FragmentSelectAwardType())
                    .addToBackStack(null)
                    .commit()
            } else {
                // 결과 확인 불가능 시 Toast 표시
                Toast.makeText(requireContext(), "결과 확인이 아직 준비되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
