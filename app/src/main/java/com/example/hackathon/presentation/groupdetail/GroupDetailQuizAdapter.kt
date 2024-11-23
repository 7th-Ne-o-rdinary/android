package com.example.hackathon.presentation.groupdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.presentation.model.User

class GroupDetailQuizAdapter (
    private val userList: List<User>,
    private val onItemClicked:(User)-> Unit
) : RecyclerView.Adapter<GroupDetailQuizAdapter.ViewHolder>(){

    // ViewHolder 클래스
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameTextView: TextView = itemView.findViewById(R.id.tv_group_detail_waiting_user_name)
    }

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_group_detail_quiz_user_name_list_item, parent, false)
        return ViewHolder(view)
    }

    // 데이터 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.userNameTextView.text = user.name
        holder.itemView.setOnClickListener { onItemClicked(user) } // 아이템 클릭 이벤트
    }

    // 아이템 수 반환
    override fun getItemCount(): Int = userList.size

}