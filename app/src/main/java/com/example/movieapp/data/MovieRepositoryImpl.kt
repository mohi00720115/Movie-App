package com.example.movieapp.data

import android.content.ContentValues.TAG
import android.util.Log
import com.example.movieapp.data.datasources.IMovieCacheDataSource
import com.example.movieapp.data.datasources.IMovieLocalDataSource
import com.example.movieapp.data.datasources.IMovieRemoteDataSource
import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.repository.IMovieRepository

class MovieRepositoryImpl(
    private val iMovieRemoteDataSource: IMovieRemoteDataSource,
    private val iMovieLocalDataSource: IMovieLocalDataSource,
    private val iMovieCacheDataSource: IMovieCacheDataSource
) : IMovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    private suspend fun getMovieFromRoom(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = iMovieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.e(TAG, "getMoviesFromApi: ${e.message}")
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            iMovieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMovieFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>
        try {
            movieList = iMovieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.e(TAG, "getMoviesFromApi: ${e.message}")
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMovieFromRoom()
            iMovieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        iMovieLocalDataSource.clearAll()
        iMovieLocalDataSource.saveMoviesToDB(newListOfMovies)
        iMovieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = iMovieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.e(TAG, "getMoviesFromApi: ${e.message}")
        }
        return movieList
    }


}
