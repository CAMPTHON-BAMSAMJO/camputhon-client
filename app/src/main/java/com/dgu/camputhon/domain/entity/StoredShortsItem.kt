package com.dgu.camputhon.domain.entity

import kotlinx.serialization.SerialName

data class StoredShortsItem (
    val id: Int,
    val shortImg: String? = null,
    val shortType: String,
    val shortUrl: String,
    val activity: String,
    val location: String,
    val timeSpent: Int,
    val createdAt: String
)