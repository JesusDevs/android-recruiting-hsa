package com.accenture.core.app.generic.error

suspend fun <T> safeApiCall(call: suspend () -> retrofit2.Response<T>): Result<T> {
    return try {
        val response = call()
        if (response.isSuccessful) {
            Result.Success(response.body()!!)
        } else {
            Result.Failure(Exception(response.errorBody()?.string() ?: "Unknown Error"))
        }
    } catch (e: Exception) {
        Result.Failure(e)
    }
}
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: Throwable) : Result<Nothing>()
}
