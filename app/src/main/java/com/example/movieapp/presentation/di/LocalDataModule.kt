package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasourcelmpl.IMovieLocalDataSourceImpl
import com.example.movieapp.data.datasources.IMovieLocalDataSource
import com.example.movieapp.data.db.IMovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule () {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(iMovieDao: IMovieDao) : IMovieLocalDataSource {
        return IMovieLocalDataSourceImpl(iMovieDao)
    }

}
