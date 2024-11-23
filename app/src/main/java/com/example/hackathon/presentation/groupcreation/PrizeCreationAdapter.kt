package com.example.hackathon.presentation.groupcreation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.databinding.GroupCreationPrizeItemBinding
import com.example.hackathon.presentation.model.PrizeCreation

class PrizeCreationAdapter(
    private val prizes: MutableList<PrizeCreation> = mutableListOf(
        PrizeCreation(index = 1, title = "", question = "", description = "")
    )
) : RecyclerView.Adapter<PrizeCreationAdapter.PrizeViewHolder>() {

    inner class PrizeViewHolder(val binding: GroupCreationPrizeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(prize: PrizeCreation) {
            binding.etGroupCreationPrizeItemPrizeName.setText(prize.title)
            binding.etGroupCreationPrizeItemQuizDescription.setText(prize.question)
            binding.etGroupCreationPrizeItemPrizeDescription.setText(prize.description)

            // EditText 값 변경 시 Prize 데이터 업데이트
            binding.etGroupCreationPrizeItemPrizeName.setOnFocusChangeListener { _, _ ->
                prize.title = binding.etGroupCreationPrizeItemPrizeName.text.toString()
            }
            binding.etGroupCreationPrizeItemQuizDescription.setOnFocusChangeListener { _, _ ->
                prize.question = binding.etGroupCreationPrizeItemQuizDescription.text.toString()
            }
            binding.etGroupCreationPrizeItemPrizeDescription.setOnFocusChangeListener { _, _ ->
                prize.description = binding.etGroupCreationPrizeItemPrizeDescription.text.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrizeViewHolder {
        val binding = GroupCreationPrizeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PrizeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrizeViewHolder, position: Int) {
        holder.bind(prizes[position])
    }

    override fun getItemCount(): Int = prizes.size

    fun addPrize(prize: PrizeCreation) {
        prizes.add(prize)
        notifyItemInserted(prizes.size - 1)
    }

    fun ensureAtLeastOneItem() {
        if (prizes.isEmpty()) {
            prizes.add(PrizeCreation(index = 1, title = "", question = "", description = ""))
            notifyItemInserted(0)
        }
    }

    fun updatePrizes(newPrizes: List<PrizeCreation>) {
        prizes.clear()
        prizes.addAll(newPrizes)
        notifyDataSetChanged()
    }
}
