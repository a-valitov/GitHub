package com.avalitov.githubviaretrofittryout.responses

import com.avalitov.githubviaretrofittryout.model.Repository

data class SearchRepoResponse(
    val items : ArrayList<Repository>
)
