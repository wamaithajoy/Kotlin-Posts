package com.example.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {
    @GET("/posts")
    fun getPost(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId")postId:Int):Call<Post>
}