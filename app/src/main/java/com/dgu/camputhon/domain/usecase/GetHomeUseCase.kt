package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.ShortsRepository
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(private val shortsRepository: ShortsRepository) {

    suspend operator fun invoke(userId: Int) = shortsRepository.getHome(userId)
}