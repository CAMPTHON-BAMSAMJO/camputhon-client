package com.dgu.camputhon.data.service

import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.response.CreateUserResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ShortsService {

    @POST("/create-user")
    suspend fun postCreateUser(@Body request: CreateUserRequestDto): CreateUserResponseDto

}