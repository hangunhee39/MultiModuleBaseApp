package com.hgh.data.util

sealed class RetrofitResult<out T> {
    data class Success<T>(val data: T) : RetrofitResult<T>()
    object SuccessWithNull : RetrofitResult<Nothing>()
    data class SuccessWithToken<T>(val data: T, val access: String, val refresh : String) : RetrofitResult<T>()
    data class Fail(val statusCode: String, val message: String) : RetrofitResult<Nothing>()
    data class Error(val exception: Exception) : RetrofitResult<Nothing>()
}

inline fun <T> RetrofitResult<T>.onSuccessWithToken(action: (T, String, String) -> Unit): RetrofitResult<T> {
    if (this is RetrofitResult.SuccessWithToken) {
        action(data, this.access, this.refresh)
    }
    return this
}

inline fun <T> RetrofitResult<T>.onSuccessWithNull(action: () -> Unit): RetrofitResult<T> {
    if (this is RetrofitResult.SuccessWithNull) {
        action()
    }
    return this
}

inline fun <T> RetrofitResult<T>.onSuccess(action: (T) -> Unit): RetrofitResult<T> {
    if (this is RetrofitResult.Success) {
        action(data)
    }
    return this
}

inline fun <T> RetrofitResult<T>.onFail(resultCode: (String, String) -> Unit): RetrofitResult<T> {
    if (this is RetrofitResult.Fail) {
        resultCode(this.statusCode, this.message)
    }
    return this
}

inline fun <T> RetrofitResult<T>.onError(action: (Exception) -> Unit): RetrofitResult<T> {
    if (this is RetrofitResult.Fail) {
        action(IllegalArgumentException("code : ${this.statusCode}, message : ${this.message}"))
    } else if (this is RetrofitResult.Error) {
        action(this.exception)
    }
    return this
}

inline fun <T> RetrofitResult<T>.onException(action: (Exception) -> Unit): RetrofitResult<T> {
    if (this is RetrofitResult.Error) {
        action(this.exception)
    }
    return this
}