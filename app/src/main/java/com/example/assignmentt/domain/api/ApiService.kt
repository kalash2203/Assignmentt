package com.example.assignmentt.domain.api

import com.example.assignmentt.data.DataResponse
import retrofit2.http.GET

interface ApiService {
    // interface class to get data
    @GET("gimme")
    suspend fun getMemes(): DataResponse
}