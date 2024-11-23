package com.example.hackathon.data.api

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class TokenDataStore(
    private val context: Context,
) {
    private val Context.dataStore by preferencesDataStore(name = "app_prefs")

    private val accessTokenPrefs = stringPreferencesKey("auth_token")

    suspend fun saveAccessToken(token: String) { // 로그인 성공시 넣기
        context.dataStore.edit { preferences ->
            preferences[accessTokenPrefs] = token
        }
    }

    suspend fun getAccessToken(): String =
        context.dataStore.data.first().let {
            it[accessTokenPrefs] ?: ""
        }
}
