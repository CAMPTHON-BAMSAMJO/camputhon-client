package com.dgu.camputhon.data.datasource

import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.request.PostShortsRequestDto
import com.dgu.camputhon.data.model.response.CreateUserResponseDto
import com.dgu.camputhon.data.model.response.PostShortsResponseDto

interface ShortsDataSource {

    suspend fun postCreateUser(request: CreateUserRequestDto): CreateUserResponseDto

    suspend fun postShorts(userID: Int, requestDto: PostShortsRequestDto): PostShortsResponseDto
}