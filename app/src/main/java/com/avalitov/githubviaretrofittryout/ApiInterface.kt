package com.avalitov.githubviaretrofittryout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface ApiInterface {

    //Call is a Retrofit method that sends a request to a webserver and returns a response

    @GET("users")
    fun getUsers() : Call<List<User>>

    @GET("repositories")
    fun getRepositories() : Call<List<Repository>>

}