package com.example.movieapp.domain.repository

import com.example.movieapp.data.model.Movie

interface IMovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?

}
