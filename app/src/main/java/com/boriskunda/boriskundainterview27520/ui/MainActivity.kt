package com.boriskunda.boriskundainterview27520.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.boriskunda.boriskundainterview27520.R
import com.boriskunda.boriskundainterview27520.utils.setStatusBarColor
import com.boriskunda.boriskundainterview27520.viewmodel.SharedViewModel


class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        setStatusBarColor(window, resources)

        sharedViewModel.openDetailsScreenLd.observe(this, Observer {

            Navigation.findNavController(
                this,
                R.id.nav_host_fragment
            ).apply {
                navigate(R.id.action_countriesListFragment_to_detailsFragment)
            }

        })

    }

}
