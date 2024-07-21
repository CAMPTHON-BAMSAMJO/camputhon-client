package com.dgu.camputhon.di

import com.dgu.camputhon.data.datasource.SampleDataSource
import com.dgu.camputhon.data.datasource.datasourceimpl.SampleDataSourceImpl
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
}