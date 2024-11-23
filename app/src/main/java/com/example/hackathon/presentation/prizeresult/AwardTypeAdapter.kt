package com.example.hackathon.presentation.prizeresult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R

class AwardTypeAdapter(
    private val awardTypeList: List<AwardType>, // Replace with your data model
    private val onItemClick: (AwardType) -> Unit // Callback for item click
) : RecyclerView.Adapter<AwardTypeAdapter.AwardTypeViewHolder>() {

    data class AwardType(val id: Int, val name: String, val imageResId: Int)

    inner class AwardTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val awardImage: ImageView = itemView.findViewById(R.id.iv_award_type_list_item_image)
        private val awardName: TextView = itemView.findViewById(R.id.iv_award_type_list_item_title)

        fun bind(awardType: AwardType) {
            awardImage.setImageResource(awardType.imageResId)
            awardName.text = awardType.name
            itemView.setOnClickListener { onItemClick(awardType) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwardTypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_award_type_list_item, parent, false)
        return AwardTypeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AwardTypeViewHolder, position: Int) {
        holder.bind(awardTypeList[position])
    }

    override fun getItemCount(): Int = awardTypeList.size
}
