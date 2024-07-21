package com.dgu.camputhon.data.repository

import androidx.datastore.core.DataStore
import com.dgu.camputhon.domain.entity.UserUUID
import com.dgu.camputhon.domain.repository.UuidRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UuidRepositoryImpl @Inject constructor(private val dataStore: DataStore<UserUUID>) :
    UuidRepository {

    override suspend fun setUUID(uuid: String) {
        dataStore.updateData { UserUUID(uuid) }
    }

    override suspend fun getUUID(): UserUUID = dataStore.data.first()
}