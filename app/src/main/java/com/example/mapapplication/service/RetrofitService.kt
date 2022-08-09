package com.example.mapapplication.service

import com.example.mapapplication.pojo.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("v3/poi")
    suspend fun getPOI(@Query(value = "distance") distance: Int,
                       @Query(value = "distanceunit") distanceunit: String,
                       @Query(value = "latitude") latitude: Double,
                       @Query(value = "longitude") longitude: Double,
                       @Query(value = "key") key: String): Response<ArrayList<Results>>
}