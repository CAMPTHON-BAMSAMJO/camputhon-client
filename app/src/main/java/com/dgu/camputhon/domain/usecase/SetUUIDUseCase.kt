package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.UuidRepository
import javax.inject.Inject

class SetUUIDUseCase @Inject constructor(private val uuidRepository: UuidRepository) {

    suspend operator fun invoke(uuid: String) = uuidRepository.setUUID(uuid)
}