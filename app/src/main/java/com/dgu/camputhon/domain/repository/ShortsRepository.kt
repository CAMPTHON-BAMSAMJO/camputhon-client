package com.dgu.camputhon.domain.repository

interface ShortsRepository {

    suspend fun postCreateUser(uuid: String, sex: String): Result<Boolean>
}