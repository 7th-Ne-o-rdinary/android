package com.example.hackathon.presentation.prizeresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.databinding.FragmentAwardTypeListItemBinding
import com.example.hackathon.presentation.model.PrizeResult

class PrizeResultAdapter : RecyclerView.Adapter<PrizeResultAdapter.PrizeResultViewHolder>() {

    private val prizeResults = mutableListOf<PrizeResult>()

    fun updateItems(newItems: List<PrizeResult>) {
        prizeResults.clear()
        prizeResults.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrizeResultViewHolder {
        val binding = FragmentAwardTypeListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PrizeResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrizeResultViewHolder, position: Int) {
        holder.bind(prizeResults[position])
    }

    override fun getItemCount(): Int = prizeResults.size

    class PrizeResultViewHolder(private val binding: FragmentAwardTypeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(prizeResult: PrizeResult) {
            binding.ivAwardTypeListItemTitle.text = prizeResult.prize.title
        }
    }
}
