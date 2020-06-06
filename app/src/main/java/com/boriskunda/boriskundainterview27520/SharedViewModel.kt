package com.boriskunda.boriskundainterview27520

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val openDetailsScreenSld: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val openDetailsScreenLd: LiveData<Boolean> = openDetailsScreenSld
    private val selectedCountryMld: MutableLiveData<Country> = MutableLiveData()
    var selectedCountryLd: LiveData<Country> = selectedCountryMld
    private val repo: Repo = Repo.instance
    val countriesListLd: LiveData<List<Country>> = repo.countriesListMld


    fun loadCountriesList() {
        repo.loadCountries(getApplication())
    }

    fun openDetailsScreen() {
        openDetailsScreenSld.call()
    }

    fun setCurrentCountry(country: Country) {
        selectedCountryMld.value = country
    }

}