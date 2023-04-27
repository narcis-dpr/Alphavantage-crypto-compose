package com.example.alphavantagecomposecrypto.utiles

sealed class ResultWrapper<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : ResultWrapper<T>(data)
    class Error<T>(message: String, data: T?) : ResultWrapper<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true) : ResultWrapper<T>(null)
}
