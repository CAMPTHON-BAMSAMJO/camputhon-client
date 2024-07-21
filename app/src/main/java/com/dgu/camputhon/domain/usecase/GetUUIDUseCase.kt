package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.UuidRepository
import javax.inject.Inject

class GetUUIDUseCase @Inject constructor(private val uuidRepository: UuidRepository) {

    suspend operator fun invoke() = uuidRepository.getUUID()
}