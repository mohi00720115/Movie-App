package com.example.movieapp.domain.usecases

import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.repository.IMovieRepository

class UpdateMoviesUseCase(
    private val iMovieRepository: IMovieRepository
) {

    suspend fun execute() : List<Movie>? = iMovieRepository.updateMovies()
}
