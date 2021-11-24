package com.example.contriesflagapi.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*



data class contriemodel( @Json(name = "name") var name  : String = "Sadi", @Json(name = "flag") var flag : String = "")

data class dataarray(@Json(name = "error") val error: Boolean = false,@Json(name = "msg") val msg:String = "",
                     @Json(name = "data") var data: List<contriemodel>)
