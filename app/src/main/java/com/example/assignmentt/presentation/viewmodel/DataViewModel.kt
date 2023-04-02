package com.example.assignmentt.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentt.data.DataResponse
import com.example.assignmentt.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val dataRepository: DataRepository
): ViewModel() {
    private val _postLiveData: MutableLiveData<DataResponse> = MutableLiveData()
    val postLiveData get() = _postLiveData

    fun getMemes(){
        viewModelScope.launch {
            dataRepository.getData().catch { e->
                Log.d("main", "getMovie: ${e.message}")
            }.collect{response->
                _postLiveData.value = response
            }
        }
    }
}