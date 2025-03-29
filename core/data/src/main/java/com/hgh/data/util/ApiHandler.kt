package com.hgh.data.util

import com.google.gson.Gson
import retrofit2.Response

suspend fun <T : Any, R : Any> apiHandler(
    execute: suspend () -> Response<T>,
    mapper: (T) -> R
): RetrofitResult<R> {
//    if (isOnline().not()) {
//        return RetrofitResult.Error(Exception(RemoteModule.NETWORK_EXCEPTION_OFFLINE_CASE))
//    }

    return try {
        val response = execute()
        val body = response.body()

        if (response.isSuccessful) {
            body?.let {
                val access = response.headers()["authorization"]
                val refresh = response.headers()["refresh_token"]

                if (access != null && refresh != null) {
                    RetrofitResult.SuccessWithToken(mapper(it), access, refresh)
                } else {
                    RetrofitResult.Success(mapper(it))
                }
            } ?: run {
                RetrofitResult.SuccessWithNull
            }
        } else {
            getFailDataResult(response)
        }
    } catch (e: Exception) {
        RetrofitResult.Error(e)
    }
}


fun <T : Any> getFailDataResult(response: Response<T>): RetrofitResult.Fail {
    val errorBody = response.errorBody()?.string()
    val gson = Gson()

    val errorResponse = try {
        gson.fromJson(errorBody, ErrorResponse::class.java)
    } catch (e: Exception) {
        null
    }

    return if (errorResponse != null) {
        RetrofitResult.Fail(statusCode = errorResponse.code ?: "-999", message = errorResponse.message ?: "error")
    } else {
        RetrofitResult.Fail(statusCode = response.code().toString(), message = response.message())
    }
}