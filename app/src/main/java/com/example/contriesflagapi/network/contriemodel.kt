package com.example.contriesflagapi.network

import com.squareup.moshi.Json

data class contriemodel(@Json(name = "name") val name : String, @Json(name = "flag") val flag : String)
