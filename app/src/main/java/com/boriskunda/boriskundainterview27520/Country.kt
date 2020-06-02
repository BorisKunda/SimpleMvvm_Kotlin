package com.boriskunda.boriskundainterview27520

import com.google.gson.annotations.SerializedName

open class Country(
    val name: String,
    @SerializedName("flag")
    val flagUrl: String,
    val capital: String,
    val nativeName: String,
    val region: String
)
