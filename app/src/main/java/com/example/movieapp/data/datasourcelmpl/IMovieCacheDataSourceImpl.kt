package com.example.movieapp.data.datasourcelmpl

import com.example.movieapp.data.datasources.IMovieCacheDataSource
import com.example.movieapp.data.model.Movie

class IMovieCacheDataSourceImpl : IMovieCacheDataSource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
