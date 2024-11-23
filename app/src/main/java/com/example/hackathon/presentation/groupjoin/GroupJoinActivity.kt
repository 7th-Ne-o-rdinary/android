package com.example.hackathon.presentation.groupjoin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.hackathon.R
import com.example.hackathon.databinding.ActivityGroupJoinBinding
import com.example.hackathon.presentation.groupdetail.GroupDetailActivity

class GroupJoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // EditText 입력 상태 확인
        val editTexts = listOf(
            binding.etGroupJoinNum1,
            binding.etGroupJoinNum2,
            binding.etGroupJoinNum3,
            binding.etGroupJoinNum4
        )

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updateButtonState(editTexts)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        editTexts.forEach { it.addTextChangedListener(textWatcher) }

        // 버튼 클릭 이벤트
        binding.mainGroupJoinGroupBtn.setOnClickListener {
            startActivity(
                Intent(this, GroupDetailActivity::class.java).apply {
                    // 해당하는 그룹에 대한 퀴즈 참여 페이지로 이동할 수 있는 Api 연결 필요
                }
            )
        }
    }

    private fun updateButtonState(editTexts: List<EditText>) {
        val isAllFilled = editTexts.all { it.text.toString().isNotEmpty() }
        binding.mainGroupJoinGroupBtn.isEnabled = isAllFilled

        // 텍스트 색상 변경
        val textColor = if (isAllFilled) {
            ContextCompat.getColor(this, R.color.black)
        } else {
            ContextCompat.getColor(this, R.color.gray_300)
        }
        binding.mainGroupJoinGroupBtn.setTextColor(textColor)
    }
}
