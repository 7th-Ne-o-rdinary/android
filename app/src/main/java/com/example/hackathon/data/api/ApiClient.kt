package com.example.hackathon.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var apiClient: Retrofit? = null

    fun getApiClient(): Retrofit = requireNotNull(apiClient)

    fun setApiClient(
        baseUrl: String,
        interceptor: TokenInterceptor,
    ) {
        apiClient =
            Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(provideOkHttpClient(interceptor))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun provideOkHttpClient(interceptor: TokenInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            addInterceptor(interceptor)
            build()
        }

    fun getLoginService(): LoginService = getApiClient().create(LoginService::class.java)

    fun getGroupService(): GroupService = getApiClient().create(GroupService::class.java)
}
