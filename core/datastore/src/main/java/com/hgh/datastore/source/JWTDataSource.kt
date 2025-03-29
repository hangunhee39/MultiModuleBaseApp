package com.hgh.datastore.source

import kotlinx.coroutines.flow.Flow

interface JWTDataSource {
    val accessToken: Flow<String?>
    suspend fun updateAccessToken(assessToken: String)
    val refreshToken: Flow<String?>
    suspend fun updateRefreshToken(refreshToken: String)
}