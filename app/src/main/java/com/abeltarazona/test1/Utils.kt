package com.abeltarazona.test1

/**
 * Created by AbelTarazona on 8/07/2021
 */
object Utils {

    const val PUSH_DATA = "PUSH_DATA"
    const val LAUNCH_QUESTION = 123

    val listQuestions = listOf<Question>(
        Question("Canberra es la capital de Australia", false),
        Question("El Canal de Suez conecta el Mar Rojo y el Oceano Indico", true),
        Question("El inicio del \"Río Nilo\" es en Egipto", false),
        Question("El Río Amazonas es el más grande de America", true),
    )
}