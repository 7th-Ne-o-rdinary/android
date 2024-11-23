package com.example.hackathon.presentation.prizeresult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.databinding.FragmentAwardTypeListItemBinding
import com.example.hackathon.presentation.model.PrizeResult

class AwardTypeAdapter(
    private val onItemClick: (PrizeResult) -> Unit
) : RecyclerView.Adapter<AwardTypeAdapter.AwardTypeViewHolder>() {

    private val items = mutableListOf<PrizeResult>()

    fun submitList(list: List<PrizeResult>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwardTypeViewHolder {
        val binding = FragmentAwardTypeListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AwardTypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AwardTypeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class AwardTypeViewHolder(
        private val binding: FragmentAwardTypeListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(prizeResult: PrizeResult) {
            binding.ivAwardTypeListItemTitle.text = prizeResult.prize.title
            binding.root.setOnClickListener {
                onItemClick(prizeResult)
            }
        }
    }
}


