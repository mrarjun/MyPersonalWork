package com.example.mapapplication.repository

import com.example.mapapplication.service.RetrofitService
import javax.inject.Inject

class Repository @Inject constructor(_service: RetrofitService) {

    private var service = _service

    suspend fun getPOI(
        distance: Int,
        distanceunit: String,
        latitude: Double,
        longitude: Double,
        key: String
    ) = service.getPOI(distance, distanceunit, latitude, longitude,key)
}