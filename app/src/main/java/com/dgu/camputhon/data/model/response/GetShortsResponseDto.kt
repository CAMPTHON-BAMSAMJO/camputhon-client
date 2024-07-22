package com.dgu.camputhon.data.model.response

import com.dgu.camputhon.domain.entity.StoredShortsItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetShortsResponseDto(
    @SerialName("isSuccess")
    val isSuccess: Boolean,
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Results
) {
    @Serializable
    data class Results(
        @SerialName("shorts")
        val shorts: ArrayList<ShortItem>
    ) {
        @Serializable
        data class ShortItem(
            @SerialName("id")
            val id: Int,
            @SerialName("shortImg")
            val shortImg: String? = null,
            @SerialName("shortType")
            val shortType: String,
            @SerialName("shortUrl")
            val shortUrl: String,
            @SerialName("activity")
            val activity: String,
            @SerialName("location")
            val location: String,
            @SerialName("timeSpent")
            val timeSpent: Int,
            @SerialName("createdAt")
            val createdAt: String
        )
    }

    fun toMapShortsItem() = result.shorts.map { shorts ->
        StoredShortsItem(
            shorts.id,
            shorts.shortImg,
            shorts.shortType,
            shorts.shortUrl,
            shorts.activity,
            shorts.location,
            shorts.timeSpent,
            shorts.createdAt
        )
    }
}
