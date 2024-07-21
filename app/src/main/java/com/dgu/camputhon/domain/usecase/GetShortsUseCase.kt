package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.ShortsRepository
import javax.inject.Inject

class GetShortsUseCase @Inject constructor(private val shortsRepository: ShortsRepository) {

    suspend operator fun invoke(userId: Int) = shortsRepository.getShorts(userId)
}