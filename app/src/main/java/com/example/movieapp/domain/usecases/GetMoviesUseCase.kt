package com.example.movieapp.domain.usecases

import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.repository.IMovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor (
    private val iMovieRepository: IMovieRepository
) {

    suspend fun execute() : List<Movie>? = iMovieRepository.getMovies()
}
