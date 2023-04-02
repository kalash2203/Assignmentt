package com.example.assignmentt.domain.repository

import com.example.assignmentt.domain.api.ApiService
import com.example.assignmentt.data.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DataRepository  @Inject constructor(private val apiService: ApiService) {

    suspend fun getData(): Flow<DataResponse> = flow {
        val response = apiService.getMemes()
        emit(response)
    }.flowOn(Dispatchers.IO)
}