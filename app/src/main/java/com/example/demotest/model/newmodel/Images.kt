 package com.example.retrofit_yt

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("imgurl" ) var imgurl : String? = null,
  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("tag"    ) var tag    : String? = null,
  @SerializedName("order"  ) var order  : String? = null

)