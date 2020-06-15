package com.proyek.mamikos.mybook.utils

import com.proyek.mamikos.mybook.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GetService {

    @Headers("X-DreamFactory-API-Key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET(Constans.API_GENRE)
    fun getAllGenre(): Call<GenreResponse>

    @Headers("X-DreamFactory-API-Key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET(Constans.API_DETAIL_KATEGORI)
    fun getDetailCategory(
        @Query("id") id: String,
        @Query("limit") limit: String
    ): Call<BookResponse>

    @Headers("X-DreamFactory-API-Key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET(Constans.API_DETAIL_BOOK + "{book_id}")
    fun getDetailBook(@Path("book_id") book_id: String): Call<DetailBookResponse>


    @Headers("X-DreamFactory-API-Key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET(Constans.API_UPTODATE)
    fun getUpToDate(@Query("limit") limit: String): Call<NewBookResponse>

    @Headers("X-DreamFactory-API-Key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET(Constans.API_DETAIL_WRITER + "{id}")
    fun getWriter(@Path("id") id: String): Call<WriterResponse>
}