package com.dgu.camputhon.domain.repository

import com.dgu.camputhon.domain.entity.ShortsUrl
import com.dgu.camputhon.domain.entity.StoredShortsItem

interface ShortsRepository {

    suspend fun postCreateUser(uuid: String, sex: String): Result<Boolean>

    suspend fun postShorts(userId: Int, day: String, startTime: String, endTime: String, activity: String, location: String, content: String): Result<ShortsUrl>

    suspend fun getShorts(userId: Int): Result<List<StoredShortsItem>>
}