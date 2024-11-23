package com.example.hackathon.presentation.groupdetail

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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameTextView:TextView = itemView.findViewById(R.id.recycler_group_detail_waiting_user_list)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GroupDetailQuizAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(p0: GroupDetailQuizAdapter.ViewHolder, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}