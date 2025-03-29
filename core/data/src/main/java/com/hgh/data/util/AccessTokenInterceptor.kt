package com.hgh.data.util

import android.util.Log
import com.hgh.datastore.source.JWTDataSource
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AccessTokenInterceptor @Inject constructor(
    private val jwtDataSource: JWTDataSource
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val jwt: String? = runBlocking { jwtDataSource.accessToken.firstOrNull() }
        jwt?.let {
            builder.addHeader("Authorization", "$jwt")
            Log.d("엑세스",jwt )
        }
        return chain.proceed(builder.build())
    }
}