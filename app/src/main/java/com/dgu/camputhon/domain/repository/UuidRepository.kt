package com.dgu.camputhon.domain.repository

import com.dgu.camputhon.domain.entity.UserUUID

interface UuidRepository {

    suspend fun setUUID(uuid: String)

    suspend fun getUUID(): UserUUID
}