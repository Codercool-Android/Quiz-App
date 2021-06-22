package com.abeltarazona.test1.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.abeltarazona.test1.R
import com.abeltarazona.test1.SharePreferenceUtils
import com.abeltarazona.test1.data.QuizDatabase
import com.abeltarazona.test1.data.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var sharePreferencesUtils: SharePreferenceUtils? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharePreferencesUtils = SharePreferenceUtils().also {
            it.setSharedPreferences(requireContext())
        }


        val btnRegister: TextView = view.findViewById(R.id.tvRegister)

        val btnLogin: Button = view.findViewById(R.id.btnLogin)

        val etUser: EditText = view.findViewById(R.id.editTextTextPersonName)

        val etPassword: EditText = view.findViewById(R.id.editTextTextPassword)

        btnRegister.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_loginFragment_to_registerFragment2)
        }

        btnLogin.setOnClickListener {
            val user = etUser.text.toString()
            val password = etPassword.text.toString()
            GlobalScope.launch(Dispatchers.IO) {
                val quizDatabase: QuizDatabase = QuizDatabase.provideDatabase(requireContext())
                val userLogged = quizDatabase.userDao().login(user, password)
            }

            val userFromSharedPreference = sharePreferencesUtils!!.getUser()

            //sharePreferencesUtils!!.saveUser(User(name = "Pepe", password = "123"))

            // User -> Redox . Password -> 3214


            /* if (user.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Campos vacios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (user == "Redox" && password == "3214") {
                Toast.makeText(context, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Revise las credenciales", Toast.LENGTH_SHORT).show()
            }*/
        }

    }

}