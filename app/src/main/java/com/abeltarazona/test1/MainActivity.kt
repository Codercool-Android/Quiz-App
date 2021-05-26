package com.abeltarazona.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando variables locales
        var nameUser : String = ""

        // Inicializando componentes
        val tvTitleWelcome : TextView = findViewById(R.id.tvTitleWelcome)
        val btnTrue : Button = findViewById(R.id.btnTrue)
        val btnFalse: Button = findViewById(R.id.btnFalse)
        val btnIngresar : Button = findViewById(R.id.btnIngresar)
        val etName : EditText = findViewById(R.id.etName)

        // Inicializando listeners
        btnTrue.setOnClickListener {
            evaluateNameUser(nameUser, true)
        }

        btnFalse.setOnClickListener {
            evaluateNameUser(nameUser, false)
        }

        btnIngresar.setOnClickListener {
            nameUser = etName.text.toString()
            tvTitleWelcome.text = "Usuario jugando: $nameUser"
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