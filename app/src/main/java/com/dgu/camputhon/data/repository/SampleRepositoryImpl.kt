package com.dgu.camputhon.data.repository

import com.dgu.camputhon.data.datasource.SampleDataSource
import com.dgu.camputhon.domain.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(private val sampleDataSource: SampleDataSource) : SampleRepository {

    override suspend fun getSample(): Result<Boolean> = runCatching {
        sampleDataSource.getSample()
    }.fold(
        onSuccess = {
            Result.success(true)
        },
        onFailure = {
            Result.failure(it)
        }
    )
}