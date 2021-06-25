package com.abeltarazona.test1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private var sharePreferenceUtil: SharedPreferenceUtil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharePreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        val userFromSharedPreference = sharePreferenceUtil?.getUser()

        Timer().schedule(timerTask {
            if (userFromSharedPreference != null) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            } else {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        }, 2000)



    }
}