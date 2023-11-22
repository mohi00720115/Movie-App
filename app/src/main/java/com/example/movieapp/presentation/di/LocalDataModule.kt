package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasourcelmpl.IMovieLocalDataSourceImpl
import com.example.movieapp.data.datasources.IMovieLocalDataSource
import com.example.movieapp.data.db.IMovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(iMovieDao: IMovieDao) : IMovieLocalDataSource {
        return IMovieLocalDataSourceImpl(iMovieDao)
    }

}
