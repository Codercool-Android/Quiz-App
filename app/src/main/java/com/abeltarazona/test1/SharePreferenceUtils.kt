package com.abeltarazona.test1

import android.content.Context
import android.content.SharedPreferences
import com.abeltarazona.test1.data.entities.User
import com.google.gson.Gson

/**
 * Created by AbelTarazona on 21/06/2021
 */
class SharePreferenceUtils {

    companion object {
        private const val SHARED_PREFERENCE_FILE_KEY = "SHARED_PREFERENCE_FILE_KEY"
        private var sharedPreferences: SharedPreferences? = null
        private const val USER = "USER"
    }

    fun setSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCE_FILE_KEY,
            Context.MODE_PRIVATE
        )
    }

    fun saveUser(user: User) {
        val gson = Gson()
        val jsonUser: String = gson.toJson(user)
        sharedPreferences!!.edit()
            .putString(USER, jsonUser).apply()
    }

    fun getUser(): User? {
        val json = sharedPreferences!!.getString(
            USER,
            null
        )
        val gson = Gson()
        return gson.fromJson(json, User::class.java)
    }

}