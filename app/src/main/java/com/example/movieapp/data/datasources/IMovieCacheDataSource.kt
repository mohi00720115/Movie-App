package com.example.movieapp.data.datasources

import com.example.movieapp.data.model.Movie


interface IMovieCacheDataSource {

    suspend fun getMoviesFromCache() : List<Movie>

    suspend fun saveMoviesToCache(movies : List<Movie>)

}
