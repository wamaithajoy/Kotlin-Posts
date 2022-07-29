package com.example.mypost

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/posts")
    fun getPost(): Call<List<Post>>
}