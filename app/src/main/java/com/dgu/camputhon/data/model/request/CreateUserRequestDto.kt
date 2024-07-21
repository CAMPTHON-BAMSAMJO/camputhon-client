package com.dgu.camputhon.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequestDto (
    @SerialName("uuid")
    val uuid: String,
    @SerialName("sex")
    val sex: String
)