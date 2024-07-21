package com.dgu.camputhon.data.datasource.datasourceimpl

import com.dgu.camputhon.data.datasource.ShortsDataSource
import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.response.CreateUserResponseDto
import com.dgu.camputhon.data.service.ShortsService
import javax.inject.Inject

class ShortsDataSourceImpl @Inject constructor(private val apiService: ShortsService) :
    ShortsDataSource {

    override suspend fun postCreateUser(request: CreateUserRequestDto): CreateUserResponseDto =
        apiService.postCreateUser(request)
}