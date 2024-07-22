package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.ShortsRepository
import javax.inject.Inject

class PostShortsUseCase @Inject constructor(private val shortsRepository: ShortsRepository) {

    suspend operator fun invoke(
        userId: Int,
        day: String,
        startTime: String,
        endTime: String,
        activity: String,
        location: String,
        content: String
    ) = shortsRepository.postShorts(userId, day, startTime, endTime, activity, location, content)
}