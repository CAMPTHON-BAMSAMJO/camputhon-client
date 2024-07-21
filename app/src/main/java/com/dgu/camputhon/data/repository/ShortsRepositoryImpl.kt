package com.dgu.camputhon.data.repository

import com.dgu.camputhon.data.datasource.ShortsDataSource
import com.dgu.camputhon.data.model.request.CreateUserRequestDto
import com.dgu.camputhon.data.model.request.PostShortsRequestDto
import com.dgu.camputhon.domain.entity.ShortsUrl
import com.dgu.camputhon.domain.repository.ShortsRepository
import com.dgu.camputhon.domain.repository.UserIdRepository
import javax.inject.Inject

class ShortsRepositoryImpl @Inject constructor(
    private val shortsDataSource: ShortsDataSource,
    private val userRepository: UserIdRepository
) : ShortsRepository {

    override suspend fun postCreateUser(uuid: String, sex: String): Result<Boolean> = runCatching {
        shortsDataSource.postCreateUser(CreateUserRequestDto(uuid, sex))
    }.fold(
        onSuccess = {
            userRepository.setUserId(it.result)
            Result.success(true)
        },
        onFailure = {
            Result.failure(it)
        }
    )

    override suspend fun postShorts(
        userId: Int,
        day: String,
        startTime: String,
        endTime: String,
        activity: String,
        location: String,
        content: String
    ): Result<ShortsUrl> = runCatching {
        shortsDataSource.postShorts(
            userId,
            PostShortsRequestDto(day, startTime, endTime, activity, location, content)
        ).toShortsUrl()
    }
}