package com.accenture.core.domain.model

sealed class DataState<out T>(val data: T?, val message: String? = null) {
    class Idle<T> : DataState<T>(null, null)
    class Success<T>(data: T) : DataState<T>(data)
    class Error<T>(message: String, data: T? = null) : DataState<T>(data, message)
    class Loading<T>(data: T? = null) : DataState<T>(data)
    class NetworkError<T>(message: String, data: T? = null) : DataState<T>(data, message)
    class Empty<T> : DataState<T>(null, null)
}
