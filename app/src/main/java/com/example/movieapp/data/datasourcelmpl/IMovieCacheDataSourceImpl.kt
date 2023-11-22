package com.example.movieapp.data.datasourcelmpl

import com.example.movieapp.data.datasources.IMovieCacheDataSource
import com.example.movieapp.data.model.Movie
import javax.inject.Inject

class IMovieCacheDataSourceImpl @Inject constructor() : IMovieCacheDataSource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
