package com.dgu.camputhon.data.datasource

import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.response.CreateUserResponseDto

interface ShortsDataSource {

    suspend fun postCreateUser(request: CreateUserRequestDto): CreateUserResponseDto
}