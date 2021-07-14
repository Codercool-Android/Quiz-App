package com.abeltarazona.test1.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abeltarazona.test1.R
import com.abeltarazona.test1.databinding.ItemPlayerBinding
import com.abeltarazona.test1.inflate

/**
 * Created by AbelTarazona on 8/07/2021
 */
class SelectPlayerAdapter(
    val list: List<String>,
    val callback: Callback) : RecyclerView.Adapter<SelectPlayerAdapter.ViewHolder>() {

    var selectedItemPos = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_player)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        if (position == selectedItemPos) {
            holder.indicatorSelected()
        } else {
            holder.indicatorUnselected()
        }

        holder.bind(item)

        holder.itemView.setOnClickListener {
            selectedItemPos = position
            notifyDataSetChanged()
            callback.onClickPlayer(item)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemPlayerBinding.bind(view)

        fun bind(name: String) {
            with(binding) {
                tvName.text = name
            }
        }

        fun indicatorSelected() {
            binding.ivCheck.visibility = View.VISIBLE
        }

        fun indicatorUnselected() {
            binding.ivCheck.visibility = View.INVISIBLE
        }
    }

    interface Callback {
        fun onClickPlayer(name: String)
    }
}