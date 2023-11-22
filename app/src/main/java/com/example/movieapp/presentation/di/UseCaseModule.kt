package com.example.movieapp.presentation.di

import com.example.movieapp.domain.repository.IMovieRepository
import com.example.movieapp.domain.usecases.GetMoviesUseCase
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCae(movieRepository: IMovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCae(movieRepository: IMovieRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

}
