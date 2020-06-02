package com.boriskunda.boriskundainterview27520

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

object Repo {

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

}

