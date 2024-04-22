package com.example.coroutinesexample.data.datasource

import com.example.coroutinesexample.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}