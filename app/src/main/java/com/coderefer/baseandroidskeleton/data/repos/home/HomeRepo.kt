package com.coderefer.baseandroidskeleton.data.repos.home

import com.coderefer.baseandroidskeleton.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepo @Inject
constructor(homeLocalDataSource: HomeLocalDataSource,
            val homeRemoteDataSource: HomeRemoteDataSource) {

    suspend fun fetchMovies(): Flow<Result<*>> {
        return homeRemoteDataSource.fetchMovies()
    }

}