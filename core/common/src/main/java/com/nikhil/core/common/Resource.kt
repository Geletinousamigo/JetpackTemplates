package com.nikhil.core.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * Wrapper class for Network Responses
 */
sealed class Resource<T>(val data: T? = null, val message: String = "") {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}

/**
 * Wrapper for UiState of Screen Composable
 */
sealed interface UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>
    data class Error<T>(val message: String): UiState<T>
    data object Loading: UiState<Nothing>
}

fun <T> Flow<T>.asUiState(): Flow<UiState<T>> {
    return this
        .map<T, UiState<T>> {
            UiState.Success(it)
        }
        .onStart { emit(UiState.Loading) }
        .catch { emit(UiState.Error(it.message?:"")) }
}




