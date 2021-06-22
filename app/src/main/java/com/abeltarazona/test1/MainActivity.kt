package com.abeltarazona.test1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

enum class TypeSelector {
    TRUE,
    FALSE
}


class MainActivity : AppCompatActivity() {

    var questionCorrect: Int = 0
    var questionIncorrect: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando mi lista
        val listQuestions = listOf<Question>(
            Question("Canberra es la capital de Australia", false),
            Question("El Canal de Suez conecta el Mar Rojo y el Oceano Indico", true),
            Question("El inicio del \"Río Nilo\" es en Egipto", false),
            Question("El Río Amazonas es el más grande de America", true),
        )

        // Inicializando variables locales
        var nameUser: String = ""
        var currentIndex: Int = 0

        nameUser

        // Inicializando componentes
        val tvTitleWelcome: TextView = findViewById(R.id.tvTitleWelcome)
        val btnTrue: Button = findViewById(R.id.btnTrue)
        val btnFalse: Button = findViewById(R.id.btnFalse)
        val btnIngresar: Button = findViewById(R.id.btnIngresar)
        val etName: EditText = findViewById(R.id.etName)
        val tvPlayingTitle: TextView = findViewById(R.id.tvPlayingTitle)
        val tvTitleQuestion: TextView = findViewById(R.id.tvTitleQuestion)
        val btnNext: Button = findViewById(R.id.btnNext)


        // Inicializando listeners
        btnTrue.setOnClickListener {
            if (isUserLogged(nameUser)) {
                isQuestionCorrect(
                    listQuestions[currentIndex].isCorrect,
                    TypeSelector.TRUE
                ) // FALSE, TRUE
            } else {
                Toast.makeText(this, "NO EVALUAR PREGUNTA", Toast.LENGTH_SHORT).show()
            }
        }

        btnFalse.setOnClickListener {
            if (isUserLogged(nameUser)) {
                isQuestionCorrect(listQuestions[currentIndex].isCorrect, TypeSelector.FALSE)
            } else {
                Toast.makeText(this, "NO EVALUAR PREGUNTA", Toast.LENGTH_SHORT).show()
            }
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

            if (currentIndex == (listQuestions.size - 1)) {
                Toast.makeText(
                    this,
                    "Resultados finales: Correctas -> $questionCorrect // Incorrectas -> $questionIncorrect",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            currentIndex = (currentIndex + 1) % listQuestions.size
            Log.d("Codercool", "Index: $currentIndex")
            tvTitleQuestion.text = listQuestions[currentIndex].title
        }


    }

    private fun isQuestionCorrect(correct: Boolean, type: TypeSelector) {
        if (type == TypeSelector.TRUE) {

            if (correct) {
                questionCorrect++
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show()
            } else {
                questionIncorrect++
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show()
            }

        } else if (type == TypeSelector.FALSE) {
            if (!correct) {
                questionCorrect++
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show()
            } else {
                questionIncorrect++
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isUserLogged(name: String): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(this, "Por favor agrega un nombre de usuario", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}