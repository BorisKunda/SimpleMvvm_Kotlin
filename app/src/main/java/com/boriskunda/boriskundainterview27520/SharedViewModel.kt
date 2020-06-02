package com.boriskunda.boriskundainterview27520

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val openDetailsScreenSld: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val openDetailsScreen: LiveData<Boolean> = openDetailsScreenSld
    val countriesListLd: LiveData<List<Country>> = Repo.countriesListMld


    fun loadCountriesList() {
        Repo.loadCountries(getApplication())
    }

    fun openDetailsScreen() {
        openDetailsScreenSld.call()
    }

}