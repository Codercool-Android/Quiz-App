package com.abeltarazona.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Tipos de datos en Kotlin:
        - Int -> 1,2,3...10000
        - Double -> 0.3, 1.5, ...
        - Boolean -> true, false
        - String -> "Abel", "mesa", "Perú", "12310293" ....
         */

        val name : String = "Roberto"

        val tvTitleWelcome : TextView = findViewById(R.id.tvTitleWelcome)
        tvTitleWelcome.text = "Bienvenido, $name"

        val btnTrue : Button = findViewById(R.id.btnTrue)

        // CTRL + ESPACIO > Abrir sugerencias
        // Lambdas - Prog. Funcional
        // Builder
        btnTrue.setOnClickListener {
            Toast.makeText(this, "¡Ganaste!", Toast.LENGTH_LONG).show()
        }

        val btnFalse: Button = findViewById(R.id.btnFalse)

        btnFalse.setOnClickListener {
            Toast.makeText(this, "¡Perdiste! \uD83D\uDE1E", Toast.LENGTH_LONG).show()
        }



    }



}