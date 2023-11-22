package com.example.movieapp.data.datasources

import com.example.movieapp.data.model.MovieList
import retrofit2.Response

interface IMovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>

}
