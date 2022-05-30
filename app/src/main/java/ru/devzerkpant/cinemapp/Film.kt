package ru.devzerkpant.cinemapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val cover: Int,
    val title: String,
    val description: String
) : Parcelable
