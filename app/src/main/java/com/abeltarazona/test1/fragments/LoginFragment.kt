package com.abeltarazona.test1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.abeltarazona.test1.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegister : TextView = view.findViewById(R.id.tvRegister)

        val btnLogin : Button = view.findViewById(R.id.btnLogin)

        val etUser : EditText = view.findViewById(R.id.editTextTextPersonName)

        val etPassword : EditText = view.findViewById(R.id.editTextTextPassword)

        btnRegister.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment2)
        }

        btnLogin.setOnClickListener {

            // User -> Redox . Password -> 3214
            val user = etUser.text.toString()
            val password = etPassword.text.toString()

            if (user.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Campos vacios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (user == "Redox" && password == "3214") {
                Toast.makeText(context, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Revise las credenciales", Toast.LENGTH_SHORT).show()
            }
        }

    }

}