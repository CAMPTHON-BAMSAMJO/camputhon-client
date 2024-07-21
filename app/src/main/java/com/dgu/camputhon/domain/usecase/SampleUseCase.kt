package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.SampleRepository
import javax.inject.Inject


class SampleUseCase @Inject constructor(private val sampleRepository: SampleRepository) {

    suspend operator fun invoke() = sampleRepository.getSample()
}