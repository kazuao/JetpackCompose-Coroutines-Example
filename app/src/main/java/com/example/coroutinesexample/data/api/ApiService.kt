package com.example.coroutinesexample.data.api

import com.example.coroutinesexample.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "c6955cdeb0a845c2bd94d4dad349d14e", // TODO: dont push
    ): Response<NewsResponse>
}