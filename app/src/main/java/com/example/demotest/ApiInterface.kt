package com.example.retrofit_yt
import com.example.demotest.model.newmodel.ItemResponseItem
import com.example.demotest.model.newmodel.ModelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("db9421b8-df8d-4371-b352-517d530b765b")
   // @GET("/posts")
    fun getData() : Call<ModelResponse>

}