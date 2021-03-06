package com.coderefer.baseandroidskeleton.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coderefer.baseandroidskeleton.utils.event.Event

abstract class BaseViewModel : ViewModel() {

    private val _uiState = MutableLiveData<ProgressUIModel>()
    private val uiState: LiveData<ProgressUIModel>
        get() = _uiState

    protected fun showLoading() {
        emitUIState(showProgress = true)
    }

    protected fun hideLoading() {
        emitUIState(showProgress = false)
    }


    private fun emitUIState(
        showProgress: Boolean = false,
        showError: Event<Int>? = null,
        showSuccess: Event<ProgressUIModel>? = null
    ) {
        val uiModel = ProgressUIModel(showProgress, showError, showSuccess)
        _uiState.postValue(uiModel)
    }

    /**
     * UI model for showing progress
     */
    data class ProgressUIModel(
        val showProgress: Boolean,
        val showError: Event<Int>?,
        val showSuccess: Event<ProgressUIModel>?
    )
}