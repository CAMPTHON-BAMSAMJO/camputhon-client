package com.dgu.camputhon.data.service

import com.dgu.camputhon.data.model.response.SampleResponseDto
import retrofit2.http.GET

interface SampleService {

    @GET("/test")
    suspend fun getSample(): String
}