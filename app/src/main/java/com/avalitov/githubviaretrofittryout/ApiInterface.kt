package com.avalitov.githubviaretrofittryout

import com.avalitov.githubviaretrofittryout.model.Repository
import com.avalitov.githubviaretrofittryout.model.User
import com.avalitov.githubviaretrofittryout.responses.SearchRepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    //Call is a Retrofit method that sends a request to a webserver and returns a response

    @GET("users")
    fun getUsers() : Call<List<User>>

    @GET("search/repositories?q=HappyPlaces")
    //@Headers("Authorization: token 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")
    fun getRepositories() : Call<SearchRepoResponse>

}