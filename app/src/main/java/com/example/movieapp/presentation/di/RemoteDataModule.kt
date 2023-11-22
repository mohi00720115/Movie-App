package com.example.movieapp.presentation.di

import com.example.movieapp.data.api.ITMDBService
import com.example.movieapp.data.datasourcelmpl.IMovieRemoteDataSourceImpl
import com.example.movieapp.data.datasources.IMovieRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val apiKey : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: ITMDBService) : IMovieRemoteDataSource {
        return IMovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

}
