package com.dgu.camputhon.di

import com.dgu.camputhon.data.service.SampleService
import com.dgu.camputhon.data.service.ShortsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideSampleService(@CamputhonRetrofit retrofit: Retrofit): SampleService =
        retrofit.create(SampleService::class.java)

    @Provides
    @Singleton
    fun provideShortsService(@CamputhonRetrofit retrofit: Retrofit): ShortsService =
        retrofit.create(ShortsService::class.java)
}