package com.dgu.camputhon.domain.repository

import com.dgu.camputhon.domain.entity.UserID

interface UserIdRepository {

    suspend fun setUserId(userId: Int)
    suspend fun getUserId(): UserID
}