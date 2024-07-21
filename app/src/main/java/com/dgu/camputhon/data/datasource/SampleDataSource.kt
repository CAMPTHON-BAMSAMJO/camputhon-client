package com.dgu.camputhon.data.datasource

import com.dgu.camputhon.data.model.response.SampleResponseDto


interface SampleDataSource {

    suspend fun getSample(): String
}