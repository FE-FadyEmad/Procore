package com.fady.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<T> : ViewModel() {
    private val _uiState: MutableStateFlow<BaseViewState<T>> by lazy {
        MutableStateFlow(
            BaseViewState.Idle,
        )
    }
    val uiState: StateFlow<BaseViewState<T>> by lazy { _uiState }

    protected fun setState(reducer: BaseViewState<T>) {
        _uiState.update { reducer }
    }

    protected fun coroutinesScope(dispatcher: CoroutineDispatcher = Dispatchers.Main): CoroutineScope =
        CoroutineScope(
            viewModelScope.coroutineContext + dispatcher +
                CoroutineExceptionHandler { _, throwable ->
                    viewModelScope.launch {
                        setState(BaseViewState.Error(throwable))
                    }
                },
        )

    override fun onCleared() {
        super.onCleared()
        coroutinesScope().coroutineContext.cancelChildren()
    }
}
