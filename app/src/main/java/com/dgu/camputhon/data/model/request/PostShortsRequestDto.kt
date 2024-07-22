package com.dgu.camputhon.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostShortsRequestDto(
    @SerialName("day")
    val day: String,
    @SerialName("startTime")
    val startTime: String,
    @SerialName("endTime")
    val endTime: String,
    @SerialName("activity")
    val activity: String,
    @SerialName("location")
    val location: String,
    @SerialName("content")
    val content: String
)
