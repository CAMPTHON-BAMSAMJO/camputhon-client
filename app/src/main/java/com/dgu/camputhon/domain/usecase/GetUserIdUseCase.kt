package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.UserIdRepository
import javax.inject.Inject

class GetUserIdUseCase @Inject constructor(private val userIdRepository: UserIdRepository) {

    suspend operator fun invoke() = userIdRepository.getUserId()
}