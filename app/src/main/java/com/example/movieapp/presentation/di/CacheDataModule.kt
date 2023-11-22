package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasourcelmpl.IMovieCacheDataSourceImpl
import com.example.movieapp.data.datasources.IMovieCacheDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : IMovieCacheDataSource {
        return IMovieCacheDataSourceImpl()
    }

}
