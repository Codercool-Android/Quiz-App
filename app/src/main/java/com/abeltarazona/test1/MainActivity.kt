package com.abeltarazona.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Tipos de datos en Kotlin:
        - Int -> 1,2,3...10000
        - Double -> 0.3, 1.5, ...
        - Boolean -> true, false
        - String -> "Abel", "mesa", "Perú", ....
         */

        val name : String = "Roberto"

        //val titleTextView : TextView = findViewById(R.id.tvTitleBienvenida)

        //titleTextView.text = "Bienvenido $name a la programación"



    }



}