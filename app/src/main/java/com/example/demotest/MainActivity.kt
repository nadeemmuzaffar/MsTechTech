package com.example.demotest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demotest.model.newmodel.ItemResponseItem
import com.example.demotest.model.newmodel.ModelResponse
import com.example.retrofit_yt.ApiInterface
import com.example.retrofit_yt.Images
import com.example.retrofit_yt.MyAdapter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var rvMain : RecyclerView
    lateinit var myAdapter: MyAdapter

    var BASE_URL = "https://run.mocky.io/v3/"
   // var BASE_URL = "https://jsonplaceholder.typicode.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.recylerView)

        rvMain.layoutManager = LinearLayoutManager(this)

        getAllData()

    }

    private fun getAllData() {

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData = retrofit.getData()

        retroData.enqueue(object : retrofit2.Callback<ModelResponse> {
            override fun onResponse(
                call: Call<ModelResponse>,
                response: Response<ModelResponse>
            ) {
                var data = response.body()!!

                myAdapter = MyAdapter(baseContext,data.images)

                rvMain.adapter = myAdapter

              /*  Log.d("data",data.toString())*/
                Log.d("zoyeb","Done")
            }

            override fun onFailure(call: Call<ModelResponse>, t: Throwable) {
                Log.d("zoyeb",t.message!!)
            }

        })

    }
}