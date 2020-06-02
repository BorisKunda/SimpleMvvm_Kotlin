package com.boriskunda.boriskundainterview27520

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    var a:Int = 0
   // val openDetailsFragmentSld: MutableLiveData<Boolean> = MutableLiveData()
    val openDetailsFragmentLd: MutableLiveData<Int> = MutableLiveData()
    val countriesListLd: LiveData<List<Country>> = Repo.countriesListMld

    init {
        print(openDetailsFragmentLd.value.toString())
    }

    fun loadCountriesList() {
        Repo.loadCountries(getApplication())
    }

    fun openDetailsScreen() {
        print(openDetailsFragmentLd.value.toString())
        openDetailsFragmentLd.value = ++a
    }

}