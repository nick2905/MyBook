package com.proyek.mamikos.mybook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class GenreResponse(
    val resource: List<Resource>
)

@Parcelize
data class Resource(
    val count: Int,
    val icon_url: String,
    val id: Int,
    val title: String
) : Parcelable