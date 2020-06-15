package com.proyek.mamikos.mybook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class DetailBookResponse(
    val result: ResultBook,
    val success: Boolean
)

@Parcelize
data class ResultBook(
    val BookChapter_by_book_id: List<BookChapterByBookId>,
    val Related_by_book: List<RelatedByBook>,
    val User_review: String,
    val Writer_by_writer_id: WriterByWriterId,
    val auto_buy_chapter: Boolean,
    val average_rate: Int,
    val book_url: String,
    val category: String,
    val challenge_id: String,
    val chapter_count: Int,
    val chapter_paid_count: Int,
    val cover_url: String,
    val created_at: String,
    val daily: String,
    val decimal_rate: Double,
    val desc: String,
    val download: Int,
    val full_price: Int,
    val full_purchase: Boolean,
    val full_purchased: Boolean,
    val genres: List<Genre>,
    val happyhour: Boolean,
    val hashtags: List<Hashtag>,
    val id: Int,
    val isNew: Boolean,
    val is_contract_actived: Boolean,
    val is_free: Boolean,
    val is_update: Boolean,
    val nominasi: String,
    val reviews: List<Review>,
    val schedule_daily: Int,
    val schedule_task: String,
    val status: String,
    val synopsis: String,
    val time_to_vote: Boolean,
    val title: String,
    val updated_at: String,
    val url_landing: String,
    val view_count: Int,
    val vote_count: String,
    val voted: Boolean,
    val writer_id: Int
) : Parcelable

@Parcelize
data class BookChapterByBookId(
    val book_id: Int,
    val chapter_sequence: Int,
    val created_at: String,
    val id: Int,
    val is_purchased: Boolean,
    val is_readed: Boolean,
    val is_warning: Boolean,
    val like_count: Int,
    val new: Boolean,
    val price: Int,
    val schedule_task: String,
    val title: String,
    val view_by_user: Int,
    val view_count: Int
): Parcelable

@Parcelize
data class RelatedByBook(
    val cover_url: String,
    val id: Int,
    val title: String
) : Parcelable

@Parcelize
data class Genre(
    val count: Int,
    val icon_url: String,
    val id: Int,
    val is_primary: Int,
    val title: String
) : Parcelable

@Parcelize
data class Hashtag(
    val id: Int,
    val name: String
) : Parcelable

@Parcelize
data class Review(
    val User_by_reviewer_id: UserByReviewerId,
    val id: Int,
    val rating: Int,
    val review: String,
    val updated_at: String,
    val user_id: Int
) : Parcelable

@Parcelize
data class UserByReviewerId(
    val email: String,
    val id: Int,
    val name: String,
    val photo_url: String,
    val username: String
) : Parcelable