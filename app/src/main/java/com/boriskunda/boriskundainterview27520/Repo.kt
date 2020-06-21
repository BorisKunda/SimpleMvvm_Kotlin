package com.boriskunda.boriskundainterview27520

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.boriskunda.boriskundainterview27520.model.Country
import com.boriskunda.boriskundainterview27520.utils.GET_ALL_COUNTRIES_URL
import com.google.gson.Gson

class Repo private constructor() {


    var countriesListMld: MutableLiveData<List<Country>> = MutableLiveData()

    fun loadCountries(application: Application) {

        JsonArrayRequest(
            Request.Method.GET,
            GET_ALL_COUNTRIES_URL,
            null,

            Response.Listener {
                Gson().fromJson(it.toString(), Array<Country>::class.java)
                    .let { it2 ->
                        countriesListMld.value = it2.asList()
                    }
            },
            Response.ErrorListener { TODO("to be implemented") })

            .let { Volley.newRequestQueue(application).add(it) }

    }



    companion object {
        val instance: Repo by lazy { Repo() }
        /**
        The by lazy{}indicates it will be computed on the first access only.
        The evaluation of lazy properties is synchronized, the value is computed only in one thread,
        and all threads will see the same value.
         */
    }

}

