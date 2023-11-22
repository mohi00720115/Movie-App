package com.example.movieapp.data.datasourcelmpl

import com.example.movieapp.data.datasources.IMovieLocalDataSource
import com.example.movieapp.data.db.IMovieDao
import com.example.movieapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class IMovieLocalDataSourceImpl @Inject constructor(
    private val IMovieDao : IMovieDao
) : IMovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return IMovieDao.getAllMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            IMovieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            IMovieDao.deleteAllMovies()
        }
    }
}
