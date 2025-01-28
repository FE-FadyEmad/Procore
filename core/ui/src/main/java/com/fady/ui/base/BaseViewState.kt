package com.fady.ui.base


sealed interface BaseViewState<out T> {
    object Idle : BaseViewState<Nothing>

    object Loading : BaseViewState<Nothing>

    data class WithData<T>(
        val data: T,
    ) : BaseViewState<T>

    data class Error(
        val throwable: Throwable,
    ) : BaseViewState<Nothing>
}