package com.dgu.camputhon.domain.repository

import com.dgu.camputhon.domain.entity.ShortsUrl

interface ShortsRepository {

    suspend fun postCreateUser(uuid: String, sex: String): Result<Boolean>

    suspend fun postShorts(userId: Int, day: String, startTime: String, endTime: String, activity: String, location: String, content: String): Result<ShortsUrl>
}