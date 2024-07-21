package com.dgu.camputhon.data.datasource.datasourceimpl

import com.dgu.camputhon.data.datasource.SampleDataSource
import com.dgu.camputhon.data.model.response.SampleResponseDto
import com.dgu.camputhon.data.service.SampleService
import javax.inject.Inject

class SampleDataSourceImpl @Inject constructor(private val apiService: SampleService) :
    SampleDataSource {

    override suspend fun getSample(): String =
        apiService.getSample()
}