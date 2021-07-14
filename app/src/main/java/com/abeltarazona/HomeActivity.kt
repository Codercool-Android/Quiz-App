package com.abeltarazona

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.abeltarazona.test1.SessionActivity
import com.abeltarazona.test1.Utils.PUSH_DATA
import com.abeltarazona.test1.adapters.PlayerAdapter
import com.abeltarazona.test1.adapters.PlayerAdapters2
import com.abeltarazona.test1.databinding.ActivityHomeBinding
import com.abeltarazona.test1.launchActivity
import java.util.ArrayList

class HomeActivity : AppCompatActivity(), PlayerAdapter.Callback {

    lateinit var binding: ActivityHomeBinding

    private var players = mutableListOf<String>()
    private val playerAdapter: PlayerAdapter = PlayerAdapter(items = players, this)

    private val playerAdapter2 = PlayerAdapters2(::getPosition)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCompetidores.adapter = playerAdapter2

        playerAdapter2.submitList(players)

        binding.btnAddCompetidor.setOnClickListener {

            val name = binding.etCompetidor.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (players.contains(name)) {
                Toast.makeText(this, "Nombre ya ingresado", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            players.add(name)
            playerAdapter2.notifyDataSetChanged()

            binding.etCompetidor.text.clear()
        }

        binding.btnStartGame.setOnClickListener {
            if (players.isNotEmpty()) {
                launchActivity<SessionActivity>() {
                    putStringArrayListExtra(PUSH_DATA, players as ArrayList<String>)
                }
            } else {
                Toast.makeText(this, "Debe agregar jugadores", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun getPosition(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar jugador")
        builder.setMessage(players[position])

        builder.setPositiveButton("Sí") { dialog, _ ->
            players.removeAt(position)
            playerAdapter2.notifyDataSetChanged()
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    override fun onClick(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar jugador")
        builder.setMessage(players[position])

        builder.setPositiveButton("Sí") { dialog, _ ->
            players.removeAt(position)
            playerAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}