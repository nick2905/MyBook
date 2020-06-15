package com.proyek.mamikos.mybook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class WriterResponse(
    val result: ResultWriter,
    val success: Boolean
)

@Parcelize
data class ResultWriter(
    val Writer_by_user_id: WriterByUserId,
    val birthday: String,
    val coin: Int,
    val count_follower: Int,
    val count_following: Int,
    val current_level: Int,
    val deskripsi: String,
    val email: String,
    val following_user: List<String>,
    val gender: String,
    val id: Int,
    val is_following: Boolean,
    val karya: List<Karya>,
    val link_user: String,
    val name: String,
    val phone: String,
    val photo_url: String,
    val reading_list: List<String>,
    val username: String,
    val writer_id: Int,
    val writer_level: Int,
    val writer_level_name: String
) : Parcelable

@Parcelize
data class WriterByUserId(
    val id: Int,
    val royalty_id: Int,
    val status: Boolean,
    val user_id: Int
) : Parcelable

@Parcelize
data class Karya(
    val Writer_by_writer_id: WriterByWriterId,
    val bab_count: Int,
    val chapter_count: Int,
    val cover_url: String,
    val created_at: String,
    val id: Int,
    val isNew: Boolean,
    val is_update: Boolean,
    val rate_sum: Double,
    val schedule_task: String,
    val status: String,
    val title: String,
    val view_count: Int,
    val writer_id: Int
) : Parcelable