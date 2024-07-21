package com.dgu.camputhon.di

import com.dgu.camputhon.data.datasource.SampleDataSource
import com.dgu.camputhon.data.datasource.ShortsDataSource
import com.dgu.camputhon.data.datasource.datasourceimpl.SampleDataSourceImpl
import com.dgu.camputhon.data.datasource.datasourceimpl.ShortsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun providesSampleDataSource(dataSourceImpl: SampleDataSourceImpl): SampleDataSource


    @Singleton
    @Binds
    abstract fun providesShortsDataSource(dataSourceImpl: ShortsDataSourceImpl): ShortsDataSource
}