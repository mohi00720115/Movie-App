package com.example.movieapp.presentation.di

import com.example.movieapp.data.api.ITMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule (private val baseUrl : String) {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit) : ITMDBService {
        return retrofit.create(ITMDBService::class.java)
    }
}
