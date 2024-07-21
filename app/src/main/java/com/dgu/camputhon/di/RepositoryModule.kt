package com.dgu.camputhon.di

import com.dgu.camputhon.data.repository.SampleRepositoryImpl
import com.dgu.camputhon.domain.repository.SampleRepository
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
}