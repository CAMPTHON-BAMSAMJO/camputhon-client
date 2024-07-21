package com.dgu.camputhon.data.model.response

import com.dgu.camputhon.domain.entity.ShortsUrl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostShortsResponseDto(
    @SerialName("isSuccess")
    val isSuccess: Boolean,
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: ResultUrl
) {
    @Serializable
    data class ResultUrl(
        @SerialName("s3Url")
        val s3Url: String
    )

    fun toShortsUrl() = ShortsUrl(shortsUrl = result.s3Url)
}