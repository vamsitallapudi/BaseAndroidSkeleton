package com.coderefer.baseandroidskeleton.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.coderefer.baseandroidskeleton.data.database.entity.Movie

@Dao
interface HomeDao {
    @Transaction
    @Query("SELECT * FROM Movie ORDER BY title asc")
    fun getMovies(): List<Movie>
}