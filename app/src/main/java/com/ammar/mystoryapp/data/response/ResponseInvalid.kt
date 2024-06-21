package com.ammar.mystoryapp.data.response

import com.google.gson.annotations.SerializedName

data class ResponseInvalid (
    @field:SerializedName("error")
    val error: Boolean? = null,
    @field:SerializedName("message")
    val message: String? = null
)