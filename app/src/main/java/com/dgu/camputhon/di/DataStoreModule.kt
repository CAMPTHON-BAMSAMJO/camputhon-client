package com.dgu.camputhon.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.dgu.camputhon.data.datasource.datasourceimpl.UserUUIDDataSource
import com.dgu.camputhon.domain.entity.UserUUID
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val UUID_DATA_STORE_FILE_NAME = "uuid_prefs.pb"

    @Singleton
    @Provides
    fun provideUUIDDataStore(
        @ApplicationContext appContext: Context,
        uuidDataSource: UserUUIDDataSource
    ): DataStore<UserUUID> {
        return DataStoreFactory.create(
            produceFile = {
                appContext.dataStoreFile(UUID_DATA_STORE_FILE_NAME)
            },
            serializer = uuidDataSource
        )
    }
}