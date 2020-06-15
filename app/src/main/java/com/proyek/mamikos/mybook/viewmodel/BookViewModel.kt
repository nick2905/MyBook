package com.proyek.mamikos.mybook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proyek.mamikos.mybook.model.*
import com.proyek.mamikos.mybook.utils.ApiClient
import retrofit2.Call
import retrofit2.Response

class BookViewModel : ViewModel() {
    private val genreBook = MutableLiveData<GenreResponse>()
    private val bookCategory = MutableLiveData<BookResponse>()
    private val bookDetail = MutableLiveData<DetailBookResponse>()
    private val newBook = MutableLiveData<NewBookResponse>()
    private val writterBook = MutableLiveData<WriterResponse>()

    fun getAllGenre() {
        ApiClient().getServiceBook().getAllGenre()
            .enqueue(object : retrofit2.Callback<GenreResponse> {
                override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                    genreBook.value = null
                }

                override fun onResponse(
                    call: Call<GenreResponse>,
                    response: Response<GenreResponse>
                ) {
                    if (response.isSuccessful) {
                        genreBook.value = response.body()
                    } else {
                        genreBook.value = null
                    }
                }
            })
    }

    fun getAllBookCategory(idGenre: String) {
        ApiClient().getServiceBook().getDetailCategory(idGenre, 20.toString())
            .enqueue(object : retrofit2.Callback<BookResponse> {
                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    bookCategory.value = null
                }

                override fun onResponse(
                    call: Call<BookResponse>,
                    response: Response<BookResponse>
                ) {
                    if (response.isSuccessful) {
                        bookCategory.value = response.body()
                    } else {
                        bookCategory.value = null
                    }
                }
            })
    }

    fun getDetailBook(idBook: String) {
        ApiClient().getServiceBook().getDetailBook(idBook)
            .enqueue(object : retrofit2.Callback<DetailBookResponse> {
                override fun onFailure(call: Call<DetailBookResponse>, t: Throwable) {
                    bookDetail.value = null
                }

                override fun onResponse(
                    call: Call<DetailBookResponse>,
                    response: Response<DetailBookResponse>
                ) {
                    if (response.isSuccessful) {
                        bookDetail.value = response.body()
                    } else {
                        bookDetail.value = null
                    }
                }

            })
    }

    fun getBookUpTodate() {
        ApiClient().getServiceBook().getUpToDate(7.toString())
            .enqueue(object : retrofit2.Callback<NewBookResponse> {
                override fun onFailure(call: Call<NewBookResponse>, t: Throwable) {
                    newBook.value = null
                }

                override fun onResponse(
                    call: Call<NewBookResponse>,
                    response: Response<NewBookResponse>
                ) {
                    if (response.isSuccessful) {
                        newBook.value = response.body()
                    } else {
                        newBook.value = null
                    }
                }

            })
    }

    fun getWriter(idWritter: String) {
        ApiClient().getServiceBook().getWriter(idWritter)
            .enqueue(object : retrofit2.Callback<WriterResponse> {
                override fun onFailure(call: Call<WriterResponse>, t: Throwable) {
                    writterBook.value = null
                }

                override fun onResponse(
                    call: Call<WriterResponse>,
                    response: Response<WriterResponse>
                ) {
                    if (response.isSuccessful) {
                        writterBook.value = response.body()
                    } else {
                        writterBook.value = null
                    }
                }

            })
    }

    fun setDataGenre(): MutableLiveData<GenreResponse> {
        return genreBook
    }

    fun setDataCategoryBook(): MutableLiveData<BookResponse> {
        return bookCategory
    }

    fun setDataDetailBook(): MutableLiveData<DetailBookResponse> {
        return bookDetail
    }

    fun setDataNewBook(): MutableLiveData<NewBookResponse> {
        return newBook
    }

    fun setDataWritter(): MutableLiveData<WriterResponse> {
        return writterBook
    }
}