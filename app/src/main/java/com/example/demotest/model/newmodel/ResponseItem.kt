package com.example.retrofit_yt
import com.google.gson.annotations.SerializedName


data class ResponseItem (

  @SerializedName("images" ) var images : ArrayList<Images> = arrayListOf()

)