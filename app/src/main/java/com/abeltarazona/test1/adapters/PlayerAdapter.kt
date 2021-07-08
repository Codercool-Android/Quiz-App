package com.abeltarazona.test1.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abeltarazona.test1.R
import com.abeltarazona.test1.databinding.ItemCompetidorBinding
import com.abeltarazona.test1.inflate

/**
 * Created by AbelTarazona on 6/07/2021
 */
class PlayerAdapter(val items: List<String>, val callback: Callback) :
    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_competidor)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCompetidorBinding.bind(view)

        fun bind(name: String) {
            with(binding) {
                textView7.text = name
                root.setOnClickListener {
                    callback.onClick(adapterPosition)
                }
            }
        }
    }

    interface Callback {
        fun onClick(position: Int)
    }
}