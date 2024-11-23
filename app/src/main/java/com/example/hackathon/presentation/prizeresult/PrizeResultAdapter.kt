package com.example.hackathon.presentation.prizeresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.databinding.FragmentAwardTypeListItemBinding
import com.example.hackathon.presentation.model.PrizeResult

class PrizeResultAdapter(
    private val onItemClick: (PrizeResult) -> Unit
) : ListAdapter<PrizeResult, PrizeResultAdapter.PrizeResultViewHolder>(PrizeResultDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrizeResultViewHolder {
        val binding = FragmentAwardTypeListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PrizeResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrizeResultViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    class PrizeResultViewHolder(
        private val binding: FragmentAwardTypeListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PrizeResult, onItemClick: (PrizeResult) -> Unit) {
            binding.ivAwardTypeListItemTitle.text = item.prize.title
            binding.root.setOnClickListener { onItemClick(item) }
        }
    }

    class PrizeResultDiffCallback : DiffUtil.ItemCallback<PrizeResult>() {
        override fun areItemsTheSame(oldItem: PrizeResult, newItem: PrizeResult): Boolean {
            return oldItem.prize.id == newItem.prize.id
        }

        override fun areContentsTheSame(oldItem: PrizeResult, newItem: PrizeResult): Boolean {
            return oldItem == newItem
        }
    }
}
