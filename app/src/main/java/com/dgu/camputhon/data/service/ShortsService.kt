package com.dgu.camputhon.data.service

import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.request.PostShortsRequestDto
import com.dgu.camputhon.data.model.response.CreateUserResponseDto
import com.dgu.camputhon.data.model.response.GetHomeResponseDto
import com.dgu.camputhon.data.model.response.GetShortsResponseDto
import com.dgu.camputhon.data.model.response.PostShortsResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ShortsService {

    @POST("/create-user")
    suspend fun postCreateUser(@Body request: CreateUserRequestDto): CreateUserResponseDto

    @POST("/shorts")
    suspend fun postShorts(@Query("userId") userId: Int, @Body request: PostShortsRequestDto): PostShortsResponseDto

    @GET("/shorts")
    suspend fun getShorts(@Query("userId") userId: Int): GetShortsResponseDto

    @GET("/home")
    suspend fun getHome(@Query("userId") userId: Int): GetHomeResponseDto
}