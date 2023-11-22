package com.example.movieapp.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.db.IMovieDao
import com.example.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(application: Application) : TMDBDatabase {
        return Room.databaseBuilder(application, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase) : IMovieDao {
        return tmdbDatabase.movieDao()
    }
}
