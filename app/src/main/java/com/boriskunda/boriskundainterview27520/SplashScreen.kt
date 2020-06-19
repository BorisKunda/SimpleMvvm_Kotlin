package com.boriskunda.boriskundainterview27520

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({

            Intent(this@SplashScreen, MainActivity::class.java).let {
                startActivity(it)
                finish()
            }

        }, SPLASH_DURATION)

    }


}