package com.avalitov.githubviaretrofittryout.model

import com.avalitov.githubviaretrofittryout.model.User

data class Repository(
    val id : String,
    val name : String,
    val owner : User
)
