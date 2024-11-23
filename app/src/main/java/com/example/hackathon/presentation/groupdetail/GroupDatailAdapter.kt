package com.example.hackathon.presentation.groupdetail


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.databinding.FragmentGroupDetailWatingUserNameListItemBinding
import com.example.hackathon.presentation.model.User

class GroupDetailAdapter : RecyclerView.Adapter<GroupDetailAdapter.GroupDetailViewHolder>() {

    private val users = mutableListOf<User>()
    private val iconDrawables = listOf(
        R.drawable.ic_group_detail_waiting_list1,
        R.drawable.ic_group_detail_waiting_list2,
        R.drawable.ic_group_detail_waiting_list3,
        R.drawable.ic_group_detail_waiting_list4
    )

    inner class GroupDetailViewHolder(val binding: FragmentGroupDetailWatingUserNameListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupDetailViewHolder {
        val binding = FragmentGroupDetailWatingUserNameListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GroupDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupDetailViewHolder, position: Int) {
        val user = users[position]
        holder.binding.tvGroupDetailWaitingUserName.text = user.name

        // 이미지를 순서대로 반복 설정
        val drawableIndex = position % iconDrawables.size
        holder.binding.ivGroupDetailWaitingIcon.setImageResource(iconDrawables[drawableIndex])
    }

    override fun getItemCount(): Int = users.size

    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }
}

