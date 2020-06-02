package com.boriskunda.boriskundainterview27520

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fr, CountriesListFragment()).commit()

        sharedViewModel.openDetailsScreen.observe(this, Observer {
            supportFragmentManager.beginTransaction().replace(R.id.container_fr, DetailsFragment())
                .addToBackStack(null).commit()
        })

    }

}
