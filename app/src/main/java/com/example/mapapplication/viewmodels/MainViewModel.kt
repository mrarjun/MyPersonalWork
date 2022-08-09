package com.example.mapapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mapapplication.pojo.Results
import com.example.mapapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repo: Repository) : ViewModel() {
    val apiKey: String = "1e2cb9c6-a0e9-4a68-bc09-f3c97a6bd8e4"
    private var repository = repo
    private val _resultData = MutableLiveData<ArrayList<Results>>()

   suspend fun getPOIData(): MutableLiveData<ArrayList<Results>> {
            val response = repository.getPOI(5, "km", 52.526, 13.415, apiKey)
            if (response.isSuccessful) {
                _resultData.postValue(response.body())
            }
        return _resultData
    }

    fun repeatFun(): Job {
        return CoroutineScope(Dispatchers.IO).launch {
            while(isActive) {
               getPOIData()
                delay(30000)
            }
        }
    }

    fun getResult() : LiveData<ArrayList<Results>> {
        return _resultData
    }
}