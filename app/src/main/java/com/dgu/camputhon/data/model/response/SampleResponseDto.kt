package com.dgu.camputhon.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SampleResponseDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("data")
    val data: String,
    @SerialName("error")
    val error: Boolean?,
)