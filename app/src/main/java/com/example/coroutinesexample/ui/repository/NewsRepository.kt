package com.example.coroutinesexample.ui.repository

import android.util.Log
import com.example.coroutinesexample.data.datasource.NewsDataSource
import com.example.coroutinesexample.data.entity.NewsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)
            Log.d("NewsRepository", response.message())

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { e ->
            Log.d("NewsRepository", e.localizedMessage)
            emit(ResourceState.Error(e.localizedMessage ?: "Some error in flow"))
        }
    }
}