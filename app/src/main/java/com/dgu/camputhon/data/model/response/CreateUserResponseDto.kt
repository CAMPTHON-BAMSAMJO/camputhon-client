package com.dgu.camputhon.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserResponseDto (
    @SerialName("isSuccess")
    val isSuccess: Boolean,
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Int
)