package com.example.movieapp.data.datasources

import com.example.movieapp.data.model.Movie


interface IMovieLocalDataSource {

    suspend fun getMoviesFromDB() : List<Movie>

    suspend fun saveMoviesToDB(movies : List<Movie>)

    suspend fun clearAll()

}
