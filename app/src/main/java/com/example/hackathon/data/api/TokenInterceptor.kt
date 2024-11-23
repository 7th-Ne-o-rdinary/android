package com.example.hackathon.data.api

import android.util.Log
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
    private val tokenDataStore: TokenDataStore,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        // 토큰을 비동기적으로 가져옴
        val accessToken: String =
            runBlocking {
                tokenDataStore.getAccessToken()
            }

        // 토큰이 있다면 Authorization 헤더에 추가
        if (accessToken.isNotEmpty()) {
            builder.addHeader("Authorization", "Bearer $accessToken")
            Log.d(TAG, "Token added to request: $accessToken")
        } else {
            Log.d(TAG, "No token found")
        }

        return chain.proceed(builder.build())
    }

    companion object {
        private const val TAG = "com.example.hackathon.data.api.AddTokenInterceptor"
    }
}
