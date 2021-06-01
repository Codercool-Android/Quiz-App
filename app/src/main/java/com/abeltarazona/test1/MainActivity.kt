package com.abeltarazona.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando mi lista
        val listQuestions = listOf<Question>(
            Question("Canberra es la capital de Australia", true),
            Question("El Canal de Suez conecta el Mar Rojo y el Oceano Indico", true),
            Question("El inicio del \"Río Nilo\" es en Egipto", false),
            Question("El Río Amazonas es el más grande de America", true),
        )

        // Inicializando variables locales
        var nameUser : String = ""
        var currentIndex : Int = 0

        // Inicializando componentes
        val tvTitleWelcome : TextView = findViewById(R.id.tvTitleWelcome)
        val btnTrue : Button = findViewById(R.id.btnTrue)
        val btnFalse: Button = findViewById(R.id.btnFalse)
        val btnIngresar : Button = findViewById(R.id.btnIngresar)
        val etName : EditText = findViewById(R.id.etName)
        val tvPlayingTitle : TextView = findViewById(R.id.tvPlayingTitle)
        val tvTitleQuestion : TextView = findViewById(R.id.tvTitleQuestion)
        val btnNext : Button = findViewById(R.id.btnNext)



        // Inicializando listeners
        btnTrue.setOnClickListener {
            evaluateNameUser(nameUser, true)
        }

        btnFalse.setOnClickListener {
            evaluateNameUser(nameUser, false)
        }

        btnIngresar.setOnClickListener {

            nameUser = etName.text.toString()

            if (nameUser.isEmpty()) {
                Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show()
            } else {
                tvPlayingTitle.visibility = View.VISIBLE
                tvTitleWelcome.text = nameUser
            }
        }

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % listQuestions.size
            Log.d("Codercool", "Index: $currentIndex")
            tvTitleQuestion.text = listQuestions[currentIndex].title
        }


    }

    fun evaluateNameUser(name: String, isCorrect: Boolean) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Por favor agrega un nombre de usuario", Toast.LENGTH_SHORT).show()
        } else {
            if (isCorrect) {
                Toast.makeText(this, "¡Ganaste!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "¡Perdiste! \uD83D\uDE1E", Toast.LENGTH_SHORT).show()
            }
        }
    }



}