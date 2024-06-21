package com.ammar.mystoryapp.config

import com.ammar.mystoryapp.data.response.ResponseAddStories
import com.ammar.mystoryapp.data.response.ResponseDetails
import com.ammar.mystoryapp.data.response.ResponseLogins
import com.ammar.mystoryapp.data.response.ResponseRegisters
import com.ammar.mystoryapp.data.response.ResponseStories
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseRegisters

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseLogins

    @GET("stories")
    fun getStories(
        @Header("Authorization") token: String
    ): Call<ResponseStories>

    @GET("stories/{id}")
    fun detailStory(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<ResponseDetails>

    @Multipart
    @POST("stories")
    suspend fun addStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): ResponseAddStories
}