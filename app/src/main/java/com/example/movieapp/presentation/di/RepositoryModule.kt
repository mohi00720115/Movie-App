package com.example.movieapp.presentation.di
import com.example.movieapp.data.MovieRepositoryImpl
import com.example.movieapp.data.datasources.IMovieCacheDataSource
import com.example.movieapp.data.datasources.IMovieLocalDataSource
import com.example.movieapp.data.datasources.IMovieRemoteDataSource
import com.example.movieapp.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: IMovieRemoteDataSource,
        movieLocalDataSource: IMovieLocalDataSource,
        movieCacheDataSource: IMovieCacheDataSource
    ): IMovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

}
