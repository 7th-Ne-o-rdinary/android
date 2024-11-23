package com.example.hackathon.presentation.groupdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.databinding.FragmentGroupDetailWatingUserNameListItemBinding
import com.example.hackathon.presentation.model.User

class GroupDetailAdapter : RecyclerView.Adapter<GroupDetailAdapter.UserViewHolder>() {
    private val users = mutableListOf<User>()
    private val iconDrawables = listOf(
        R.drawable.ic_group_detail_waiting_list1,
        R.drawable.ic_group_detail_waiting_list2,
        R.drawable.ic_group_detail_waiting_list3,
        R.drawable.ic_group_detail_waiting_list4
    )

    inner class UserViewHolder(private val binding: FragmentGroupDetailWatingUserNameListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.tvGroupDetailWaitingUserName.text = user.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = FragmentGroupDetailWatingUserNameListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }
}
