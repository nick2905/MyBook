package com.proyek.mamikos.mybook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class NewBookResponse(
    val result: List<ResultNew>,
    val success: Boolean,
    val time: Time
)

@Parcelize
data class ResultNew(
    val Writer_by_writer_id: WriterByWriterId,
    val book_id: Int,
    val category: String,
    val chapter_count: Int,
    val cover_url: String,
    val created_at: String,
    val id: Int,
    val isNew: Boolean,
    val is_update: Boolean,
    val rate_sum: Int,
    val schedule_task: String,
    val status: String,
    val title: String,
    val view_count: Int,
    val writer_id: Int
): Parcelable

@Parcelize
data class Time(
    val book_official: Double,
    val chapter: Double,
    val chapter_book: Double,
    val chapter_new: Double,
    val rating: Double,
    val user: Double,
    val viewer: Double
): Parcelable