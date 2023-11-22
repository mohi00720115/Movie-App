package com.example.movieapp.presentation.di

import com.example.movieapp.BuildConfig
import com.example.movieapp.data.api.ITMDBService
import com.example.movieapp.data.datasourcelmpl.IMovieRemoteDataSourceImpl
import com.example.movieapp.data.datasources.IMovieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: ITMDBService): IMovieRemoteDataSource {
        return IMovieRemoteDataSourceImpl(tmdbService, BuildConfig.API_KEY)
    }

}
