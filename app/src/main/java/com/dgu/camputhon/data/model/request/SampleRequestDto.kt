package com.dgu.camputhon.data.model.request

import kotlinx.serialization.Serializable


@Serializable
data class SampleRequestDto(
    val id: Int,
    val title: String,
    val context: String,
)