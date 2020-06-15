package com.proyek.mamikos.mybook.utils

class Constans {
    companion object {
        const val API_URL = "https://cabaca.id:8443/api/v2/"

        //https://cabaca.id:8443/api/v2/writer/detail/{user_id}
        const val API_DETAIL_WRITER = "writer/detail/"

        //https://cabaca.id:8443/api/v2/book/detail/{book_id}
        const val API_DETAIL_BOOK = "book/detail/"

        const val API_KEY =
            "&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"

        //https://cabaca.id:8443/api/v2/files/covers%2Fthe-bad-guy.jpg?download=false&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948
        const val API_IMAGE = "files/"

        //https://cabaca.id:8443/api/v2/cabaca/_table/genre
        const val API_GENRE = "cabaca/_table/genre"

        //https://cabaca.id:8443/api/v2/book/category?id={genre_id}
        const val API_DETAIL_KATEGORI = "book/category"

        //https://cabaca.id:8443/api/v2/book/uptodate?limit=7
        const val API_UPTODATE = "book/uptodate"

    }
}
