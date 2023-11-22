package com.example.movieapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.db.IMovieDao
import com.example.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context : Context) : TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase) : IMovieDao {
        return tmdbDatabase.movieDao()
    }
}
