package com.dgu.camputhon.data.repository

import androidx.datastore.core.DataStore
import com.dgu.camputhon.domain.entity.UserID
import com.dgu.camputhon.domain.repository.UserIdRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UserIdRepositoryImpl @Inject constructor(private val dataStore: DataStore<UserID>): UserIdRepository {
    override suspend fun setUserId(userId: Int) {
        dataStore.updateData { UserID(userId) }
    }

    override suspend fun getUserId(): UserID = dataStore.data.first()


}