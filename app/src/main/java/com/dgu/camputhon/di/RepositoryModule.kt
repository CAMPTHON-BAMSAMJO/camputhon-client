package com.dgu.camputhon.di

import com.dgu.camputhon.data.repository.SampleRepositoryImpl
import com.dgu.camputhon.data.repository.ShortsRepositoryImpl
import com.dgu.camputhon.data.repository.UserIdRepositoryImpl
import com.dgu.camputhon.data.repository.UuidRepositoryImpl
import com.dgu.camputhon.domain.repository.SampleRepository
import com.dgu.camputhon.domain.repository.ShortsRepository
import com.dgu.camputhon.domain.repository.UserIdRepository
import com.dgu.camputhon.domain.repository.UuidRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesSampleRepository(repositoryImpl: SampleRepositoryImpl): SampleRepository

    @Singleton
    @Binds
    abstract fun providesUuidRepository(repositoryImpl: UuidRepositoryImpl): UuidRepository

    @Singleton
    @Binds
    abstract fun providesShortsRepository(repositoryImpl: ShortsRepositoryImpl): ShortsRepository

    @Singleton
    @Binds
    abstract fun providesUserRepository(repositoryImpl: UserIdRepositoryImpl): UserIdRepository
}