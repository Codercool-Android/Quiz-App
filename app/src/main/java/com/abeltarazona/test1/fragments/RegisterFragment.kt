package com.abeltarazona.test1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        val btnRegister: Button = view.findViewById(R.id.btnRegister)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.title = "Registro"

        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        btnRegister.setOnClickListener {
            val testName = "User 1"
            val testPassword = "Password123"
            registerUser(testName, testPassword)
        }

    }

    private fun registerUser(testName: String, testPassword: String) {

        GlobalScope.launch(Dispatchers.IO) {
            val quizDatabase: QuizDatabase = QuizDatabase.provideDatabase(requireContext())
            quizDatabase.userDao().insert(User(name = testName, password = testPassword))
        }

    }

}