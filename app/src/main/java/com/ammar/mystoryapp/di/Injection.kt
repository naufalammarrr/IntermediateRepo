package com.ammar.mystoryapp.di

import android.content.Context
import com.ammar.mystoryapp.config.ApiConfig
import com.ammar.mystoryapp.data.pref.UserPreference
import com.ammar.mystoryapp.data.pref.UserRepository
import com.ammar.mystoryapp.data.pref.dataStore


object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService, pref)
    }
}