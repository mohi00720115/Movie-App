package com.example.movieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/** Each variable get value form SerializedName name and set it to variable name */

@Entity(tableName = "popular_movies")
data class Movie(

    @PrimaryKey
    @SerializedName("id")
    val movieId : Int,

    @SerializedName("overview")
    val overview : String,

    @SerializedName("poster_path")
    val posterPath : String,

    @SerializedName("release_date")
    val releaseDate : String,

    @SerializedName("title")
    val title : String
)
