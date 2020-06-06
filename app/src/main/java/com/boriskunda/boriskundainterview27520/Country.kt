package com.boriskunda.boriskundainterview27520

import com.google.gson.annotations.SerializedName

class Country(
    val name: String,
    @SerializedName("flag")
    val flagUrl: String,
    val capital:String,
    val region: String
)
