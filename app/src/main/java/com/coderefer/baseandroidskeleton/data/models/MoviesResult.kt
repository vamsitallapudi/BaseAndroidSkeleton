package com.coderefer.baseandroidskeleton.data.models

import com.coderefer.baseandroidskeleton.data.database.entity.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResult( @SerializedName("results") val result: List<Movie>)
