package com.example.hackathon.presentation.groupdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.hackathon.R
import com.example.hackathon.presentation.model.User

class GroupDetailQuizFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GroupDetailQuizAdapter

    private val dummyUserList = listOf(
        User(id = "1", name = "로빈"),
        User(id = "2", name = "신구"),
        User(id = "3", name = "똘이"),
        User(id = "4", name = "상우")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_group_detail_quiz, container, false)

        recyclerView = view.findViewById(R.id.recycler_group_detail_quiz_answer_list)
        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = GroupDetailQuizAdapter(dummyUserList) { user ->
            // 클릭 이벤트 처리
            println("Clicked user: ${user.name}")
        }
        recyclerView.adapter = adapter
    }

}