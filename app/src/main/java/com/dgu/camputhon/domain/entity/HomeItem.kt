package com.dgu.camputhon.domain.entity

data class HomeItem(
    val shortImg: String,
    val shortType: String,
    val advantage: String,
    val develop: String,
    val mostActivity: HomeItemActivity,
    val mostLocation: HomeItemLocation
) {
    data class HomeItemActivity(
        val id: Int,
        val activity: String,
        val percentage: Int,
        val timeSpent: Int
    )

    data class HomeItemLocation(
        val id: Int,
        val location: String,
        val percentage: Int,
        val timeSpent: Int
    )
}