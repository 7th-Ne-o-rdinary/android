package com.example.hackathon.presentation.groupdetail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.hackathon.R
import com.example.hackathon.presentation.model.User
import com.example.hackathon.presentation.prizeresult.PrizeResultActivity

class GroupDetailQuizFragment : Fragment() {

    private lateinit var button: AppCompatButton // 변수 선언

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_group_detail_quiz, container, false)

        button = view.findViewById(R.id.btn_group_detail_quiz_finish)
        button.setOnClickListener {
            val intent = Intent(requireContext(), PrizeResultActivity::class.java)
            startActivity(intent)
        }
        return view

    }
}