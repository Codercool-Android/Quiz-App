package com.abeltarazona.test1.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abeltarazona.test1.LeaderBoard
import com.abeltarazona.test1.R
import com.abeltarazona.test1.databinding.ItemLeaderboardBinding
import com.abeltarazona.test1.inflate

/**
 * Created by AbelTarazona on 8/07/2021
 */
class LeaderboardAdapter(val items: List<LeaderBoard>) :
    RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_leaderboard)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemLeaderboardBinding.bind(view)

        fun bind(leaderBoard: LeaderBoard) {
            with(binding) {
                tvPlayer.text = leaderBoard.name
                val points = "${leaderBoard.point} pts"
                tvPoints.text = points // 4 pts
            }
        }
    }

}