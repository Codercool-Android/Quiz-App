package com.abeltarazona.test1

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.abeltarazona.test1.data.entities.User
import com.google.gson.Gson
import java.lang.Exception

/**
 * Created by AbelTarazona on 24/06/2021
 */
class SharedPreferenceUtil {

    companion object {
        private const val SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE_KEY"

        private var sharedPreference: SharedPreferences? = null

        private const val USER = "USER"
    }

    fun setSharedPreference(context: Context) {
        sharedPreference = context
            .getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }

    fun saveUser(user: User) {
        val gson = Gson()

        val jsonUser: String = gson.toJson(user)

        sharedPreference!!.edit().putString(USER, jsonUser).apply()
    }

    fun getUser(): User? {

        var data: User? = null

        val jsonUser = sharedPreference!!.getString(USER, "")

        try {
            data = Gson().fromJson(jsonUser, User::class.java)
        } catch (e: Exception) {
            Log.d("Codercool", e.toString())
        }

        return data
    }

}















