package com.avalitov.githubviaretrofittryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.avalitov.githubviaretrofittryout.model.Repository
import com.avalitov.githubviaretrofittryout.model.User
import com.avalitov.githubviaretrofittryout.responses.SearchRepoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var tvText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tv_text)

        //getUsers()
        getRepositoriesFromSearch()
    }

    private fun getUsers() {
        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getUsers()
        retrofitData.enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                val responseBody = response.body()

                if (responseBody != null) {
                    val userStringBuilder = StringBuilder()
                    for (dataUnit in responseBody) {
                        userStringBuilder.append(dataUnit.login)
                        userStringBuilder.append("\n")
                    }

                    tvText.text = userStringBuilder
                }
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

    private fun getRepositoriesFromSearch() {
        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getRepositories()
        retrofitData.enqueue(object : Callback<SearchRepoResponse?> {
            override fun onResponse(call: Call<SearchRepoResponse?>, response: Response<SearchRepoResponse?>) {
                val responseBody = response.body()?.items

                if (responseBody != null) {
                    val userStringBuilder = StringBuilder()
                    for (dataUnit in responseBody) {
                        userStringBuilder.append(dataUnit.name)
                        userStringBuilder.append(" ")
                        userStringBuilder.append(dataUnit.owner.login)
                        userStringBuilder.append("\n")
                    }

                    tvText.text = userStringBuilder
                }
            }

            override fun onFailure(call: Call<SearchRepoResponse?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }


    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}