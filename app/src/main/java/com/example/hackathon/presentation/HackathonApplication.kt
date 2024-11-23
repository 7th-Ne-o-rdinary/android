package com.example.hackathon.presentation

import android.app.Application
import com.example.hackathon.data.UserRepository
import com.example.hackathon.data.api.ApiClient
import com.example.hackathon.data.api.TokenDataStore
import com.example.hackathon.data.api.TokenInterceptor

class HackathonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initApiClient()
    }

    private fun initApiClient() {
        val datastore = TokenDataStore(applicationContext)
        ApiClient.setApiClient(BASE_URL, TokenInterceptor(datastore))
        UserRepository.init(ApiClient.getLoginService(), datastore)
    }

    private companion object {
        const val BASE_URL = "http://3.39.123.168:8080/"
    }
}
