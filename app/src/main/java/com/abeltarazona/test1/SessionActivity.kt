package com.abeltarazona.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.abeltarazona.test1.Utils.LAUNCH_QUESTION
import com.abeltarazona.test1.Utils.PUSH_DATA
import com.abeltarazona.test1.adapters.LeaderboardAdapter
import com.abeltarazona.test1.adapters.SelectPlayerAdapter
import com.abeltarazona.test1.databinding.ActivityHomeBinding
import com.abeltarazona.test1.databinding.ActivitySessionBinding

class SessionActivity : AppCompatActivity(), SelectPlayerAdapter.Callback {

    lateinit var binding : ActivitySessionBinding

    private val listPlayers: MutableList<String> = mutableListOf()
    private val listLeaderBoard: MutableList<LeaderBoard> = mutableListOf()

    private val adapterLeaderBoard = LeaderboardAdapter(listLeaderBoard)
    private val adapterPlayers = SelectPlayerAdapter(listPlayers, this)

    private var playerName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySessionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = intent
        val data = intent.getStringArrayListExtra(PUSH_DATA)

        binding.rvLeaderboard.adapter = adapterLeaderBoard
        binding.rvPlayers.adapter = adapterPlayers

        if (data != null) {
            listPlayers.addAll(data) // Lista de jugadores para seleccionar
            adapterPlayers.notifyDataSetChanged()
            for (player in listPlayers) {
                listLeaderBoard.add(LeaderBoard(name = player)) // Lista de lideres
            }
            adapterLeaderBoard.notifyDataSetChanged()
        }

        binding.btnGenerateQuestion.setOnClickListener {
            if (playerName.isNotEmpty()) {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(PUSH_DATA, playerName)
                startActivityForResult(intent, LAUNCH_QUESTION)
            } else {
                Toast.makeText(this, "Seleccione un jugador", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LAUNCH_QUESTION) {

            if (resultCode == RESULT_OK) {
                val point: Int = data!!.getIntExtra("point", 0)
                val playerName: String? = data.getStringExtra("player")

                if (playerName != null) {
                    for (player in listLeaderBoard) {
                        if (playerName == player.name) {
                            val newPlayer = player.copy(point = player.point + point)
                            listLeaderBoard.remove(player)
                            listLeaderBoard.add(newPlayer)
                            listLeaderBoard.sortByDescending {
                                it.point
                            }
                            adapterLeaderBoard.notifyDataSetChanged()
                            break
                        }
                    }
                }

            } else {
                Toast.makeText(this, "No ha sido respondido la pregunta", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onClickPlayer(name: String) {
        playerName = name
    }
}