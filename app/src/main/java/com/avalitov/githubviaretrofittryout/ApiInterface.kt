package com.avalitov.githubviaretrofittryout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getUsers() : Call<List<User>>
}