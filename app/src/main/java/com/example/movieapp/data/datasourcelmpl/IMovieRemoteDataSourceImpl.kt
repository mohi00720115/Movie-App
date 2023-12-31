package com.example.movieapp.data.datasourcelmpl

import com.example.movieapp.data.api.ITMDBService
import com.example.movieapp.data.datasources.IMovieRemoteDataSource
import com.example.movieapp.data.model.MovieList
import retrofit2.Response

/** Connects to TMDBService with MovieRemoteDataSource interface */
class IMovieRemoteDataSourceImpl(
    private val ITMDBService : ITMDBService,
    private val apiKey : String
) : IMovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = ITMDBService.getPopularMovies(apiKey)

}
