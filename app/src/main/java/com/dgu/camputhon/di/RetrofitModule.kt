package com.dgu.camputhon.di

import android.util.Log
import com.dgu.camputhon.BuildConfig
import com.dgu.camputhon.util.isJsonArray
import com.dgu.camputhon.util.isJsonObject
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = BuildConfig.BASE_URL
    private val json = Json { ignoreUnknownKeys = true }
    private const val APPLICATION_JSON = "application/json"

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor { message ->
            when {
                message.isJsonObject() -> Log.d("retrofit", JSONObject(message).toString(4))
                message.isJsonArray() -> Log.d("retrofit", JSONArray(message).toString(4))
                else -> Log.d("retrofit", "CONNECTION INFO -> $message")
            }
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    @CamputhonRetrofit
    fun provideSafeTripRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(APPLICATION_JSON.toMediaType()))
            .build()

}