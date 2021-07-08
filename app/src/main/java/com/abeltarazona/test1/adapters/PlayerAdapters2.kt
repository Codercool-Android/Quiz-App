package com.abeltarazona.test1.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abeltarazona.test1.R
import com.abeltarazona.test1.databinding.ItemCompetidorBinding
import com.abeltarazona.test1.inflate

/**
 * Created by AbelTarazona on 6/07/2021
 */
class PlayerAdapters2(
    val onClick: (Int) -> Unit
) : ListAdapter<String, PlayerAdapters2.Holder>(PlayerAdapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent.inflate(R.layout.item_competidor)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCompetidorBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                onClick(adapterPosition)
            }
        }

        fun bind(name: String) {
            with(binding) {
                textView7.text = name
            }
        }
    }

}

class PlayerAdapterDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}