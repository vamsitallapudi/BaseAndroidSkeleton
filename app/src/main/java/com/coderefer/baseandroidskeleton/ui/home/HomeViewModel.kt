package com.coderefer.baseandroidskeleton.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.coderefer.baseandroidskeleton.data.database.entity.Movie
import com.coderefer.baseandroidskeleton.data.repos.home.HomeRepo
import com.coderefer.baseandroidskeleton.ui.base.BaseViewModel
import com.coderefer.baseandroidskeleton.utils.CoroutineDispatchProvider
import com.coderefer.baseandroidskeleton.utils.Result
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(val dispatchProvider: CoroutineDispatchProvider, val repo:HomeRepo) : BaseViewModel() {

    private val moviesMutableLiveData = MutableLiveData<List<Movie>>()
    val stockLiveData: LiveData<List<Movie>>
        get() = moviesMutableLiveData


    fun fetchMovies() : Job {
        return viewModelScope.launch(dispatchProvider.io) {
            withContext(dispatchProvider.main) {
                showLoading()
            }
            val result = repo.fetchMovies()
            result.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val movieList = it.data
                        moviesMutableLiveData.postValue(movieList as List<Movie>?)
                    }
                    is Result.Error -> {

                    }
                    is Result.Loading -> {

                    }
                }
            }
        }
    }
}