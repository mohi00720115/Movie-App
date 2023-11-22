package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasourcelmpl.IMovieCacheDataSourceImpl
import com.example.movieapp.data.datasources.IMovieCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : IMovieCacheDataSource {
        return IMovieCacheDataSourceImpl()
    }

}
