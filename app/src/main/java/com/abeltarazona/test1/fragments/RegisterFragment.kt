package com.abeltarazona.test1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.abeltarazona.test1.R
import com.abeltarazona.test1.data.QuizDatabase
import com.abeltarazona.test1.data.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configToolbar(view)

        val btnRegister: Button = view.findViewById(R.id.btnRegister)

        val etUser: EditText = view.findViewById(R.id.etUser)
        val etPassword: EditText = view.findViewById(R.id.etPassword)
        val etPasswordConfirmation: EditText = view.findViewById(R.id.etPasswordConfirmation)
        val cbTerms: CheckBox = view.findViewById(R.id.cbTermsAndConditions)

        btnRegister.setOnClickListener {

            val testName = etUser.text.toString()
            val testPassword = etPassword.text.toString()
            val testConfirmation = etPasswordConfirmation.text.toString()

            if (testPassword != testConfirmation) {
                Toast.makeText(context, "Contraseña debe coincidir con la validación", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!cbTerms.isChecked) {
                Toast.makeText(context, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registerUser(testName, testPassword)
        }

    }

    private fun registerUser(testName: String, testPassword: String) {

        GlobalScope.launch(Dispatchers.IO) {
            val quizDatabase: QuizDatabase = QuizDatabase.provideDatabase(requireContext())
            quizDatabase.userDao().insert(User(name = testName, password = testPassword))
        }

        Toast.makeText(context, "Registro exitoso!", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(requireView()).popBackStack()
    }

    private fun configToolbar(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.title = "Registro"

        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }

}