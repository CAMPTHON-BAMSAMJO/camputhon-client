package com.dgu.camputhon.data.model.response

import com.dgu.camputhon.domain.entity.HomeItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetHomeResponseDto(
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
        @SerialName("shortImg")
        val shortImg: String? = null,
        @SerialName("shortType")
        val shortType: String,
        @SerialName("advantage")
        val advantage: String,
        @SerialName("develop")
        val develop: String,
        @SerialName("mostActivity")
        val mostActivity: ActivityItem,
        @SerialName("mostLocation")
        val mostLocation: LocationItem
    ) {
        @Serializable
        data class ActivityItem(
            @SerialName("id")
            val id: Int,
            @SerialName("activity")
            val activity: String,
            @SerialName("percentage")
            val percentage: Int? = null,
            @SerialName("timeSpent")
            val timeSpent: Int
        )

        @Serializable
        data class LocationItem(
            @SerialName("id")
            val id: Int,
            @SerialName("location")
            val location: String,
            @SerialName("percentage")
            val percentage: Int? = null,
            @SerialName("timeSpent")
            val timeSpent: Int
        )
    }

    fun toMapHomeItem() = HomeItem(
        result.shortImg ?: "",
        result.shortType,
        result.advantage,
        result.develop,
        HomeItem.HomeItemActivity(
            result.mostActivity.id,
            result.mostActivity.activity,
            result.mostActivity.percentage ?: 0,
            result.mostActivity.timeSpent
        ),
        HomeItem.HomeItemLocation(
            result.mostLocation.id,
            result.mostLocation.location,
            result.mostLocation.percentage ?: 0,
            result.mostLocation.timeSpent
        )
    )
}