package com.dgu.camputhon.domain.repository

interface SampleRepository {

    suspend fun getSample(): Result<Boolean>
}