package com.hgh.data.util

import android.content.Context
import com.hgh.datastore.source.JWTDataSource
import com.hgh.data.remote.NoAuthService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Provider

class Authenticator @Inject constructor(
    private val jwtDataStore: JWTDataSource,
    @ApplicationContext private val context: Context,
    private val renewServiceLazy: Provider<NoAuthService>
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val refreshToken = runBlocking { jwtDataStore.refreshToken.firstOrNull() }
        if (refreshToken.isNullOrEmpty()) return null
        if (response.code == CODE_TOKEN_EXPIRED) {
            if (updateToken()) {
                response.request.newBuilder().apply {
                    removeHeader("Authorization")
                    addHeader("Authorization", runBlocking { jwtDataStore.accessToken.firstOrNull() } ?: "")
                }.build()
            } else {
                naviToLogin()
            }
        }
        return null
    }

    /** 토큰 갱신 **/
    private fun updateToken(): Boolean = runBlocking {
//        val authService = userServiceLazy.get()
//        try {
//            val response = authService.patchUserRenewAccess(
//                AccessRenewReqDto(
//                    refreshToken = ds.getAccessToken() ?: ""
//                )
//            )
//            if (response.isSuccessful && response.body() != null) {
//                val responseHeader = response.headers()
//                ds.setAccessToken(responseHeader["authorization"] ?: "")
//                ds.setRefreshToken(responseHeader["refresh_token"] ?: "")
//                return@runBlocking true
//            } else {
//                Log.d("Authenticator", "updateToken fail ")
//                return@runBlocking false
//            }
//        } catch (e: Exception) {
//            Log.d("Authenticator", "updateToken error")
//        }
        return@runBlocking false
    }

    /** 로그인 화면 이동 */
    private fun naviToLogin() {
//        val intent = Intent(context, SignActivity::class.java)
//            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        context.startActivity(intent)
    }

    companion object {
        const val CODE_TOKEN_EXPIRED = 401
    }
}