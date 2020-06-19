package com.boriskunda.boriskundainterview27520

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.Navigation


class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        sharedViewModel.openDetailsScreenLd.observe(this, Observer {

            Navigation.findNavController(this, R.id.nav_host_fragment).apply {
                navigate(R.id.action_countriesListFragment_to_detailsFragment)
            }

        })

    }

}
