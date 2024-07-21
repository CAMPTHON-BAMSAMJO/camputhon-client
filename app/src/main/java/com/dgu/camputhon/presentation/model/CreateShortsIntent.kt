package com.dgu.camputhon.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateShortsIntent(
    val  day: String,
    val startTime: String,
    val endTime: String,
    val activity: String,
    val location: String,
    val content: String
): Parcelable
