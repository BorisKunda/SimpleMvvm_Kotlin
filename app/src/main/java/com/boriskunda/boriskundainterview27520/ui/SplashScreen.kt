package com.boriskunda.boriskundainterview27520.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.boriskunda.boriskundainterview27520.R
import com.boriskunda.boriskundainterview27520.utils.SPLASH_DURATION
import com.boriskunda.boriskundainterview27520.utils.setStatusBarColor

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        setStatusBarColor(window, resources)

        Handler().postDelayed({

            Intent(this@SplashScreen, MainActivity::class.java).let {
                startActivity(it)
                finish()
            }

        }, SPLASH_DURATION)

    }


}