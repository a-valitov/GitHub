package com.avalitov.github.responses

import com.avalitov.github.model.Repository

data class SearchRepoResponse(
    val items : ArrayList<Repository>
)
