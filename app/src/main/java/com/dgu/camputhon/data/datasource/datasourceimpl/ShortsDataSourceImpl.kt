package com.dgu.camputhon.data.datasource.datasourceimpl

import com.dgu.camputhon.data.datasource.ShortsDataSource
import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.request.PostShortsRequestDto
import com.dgu.camputhon.data.model.response.CreateUserResponseDto
import com.dgu.camputhon.data.model.response.GetHomeResponseDto
import com.dgu.camputhon.data.model.response.GetShortsResponseDto
import com.dgu.camputhon.data.model.response.PostShortsResponseDto
import com.dgu.camputhon.data.service.ShortsService
import javax.inject.Inject

class ShortsDataSourceImpl @Inject constructor(private val apiService: ShortsService) :
    ShortsDataSource {

    override suspend fun postCreateUser(request: CreateUserRequestDto): CreateUserResponseDto =
        apiService.postCreateUser(request)

    override suspend fun postShorts(userID: Int, requestDto: PostShortsRequestDto): PostShortsResponseDto =
        apiService.postShorts(userID, requestDto)

    override suspend fun getShorts(userID: Int): GetShortsResponseDto =
        apiService.getShorts(userID)

    override suspend fun getHome(userID: Int): GetHomeResponseDto =
        apiService.getHome(userID)
}