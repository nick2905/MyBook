package com.proyek.mamikos.mybook.ui.detailBook

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.DetailBookResponse
import com.proyek.mamikos.mybook.model.RelatedByBook
import com.proyek.mamikos.mybook.ui.detailPenulis.DetailPenulis
import com.proyek.mamikos.mybook.utils.Constans
import com.proyek.mamikos.mybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_detail_book.*

class DetailBookActivity : AppCompatActivity() {
    private lateinit var detailBookViewModel: BookViewModel
    lateinit var idBook: String
    lateinit var idPenulis: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)

        idBook = intent.getStringExtra("idBooks")

        rvDetailBookRelated.setHasFixedSize(true)
        rvDetailBookRelated.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        lnrDetailBook.visibility = View.INVISIBLE

        refreshDetailBook.setOnRefreshListener {
            refreshDetailBook.isRefreshing = true
            showDataBook(idBook)
        }

        btnLihatPenulis.setOnClickListener {
            val intent = Intent(this, DetailPenulis::class.java)
            intent.putExtra("IdWritter", idPenulis)
            startActivity(intent)
        }

        refreshDetailBook.isRefreshing = true
        showDataBook(idBook)
    }

    private fun showDataBook(idBooks: String) {
        detailBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        detailBookViewModel.getDetailBook(idBooks)
        detailBookViewModel.setDataDetailBook().observe(this, Observer { book ->
            if (book != null) {
                lnrDetailBook.visibility = View.VISIBLE
                refreshDetailBook.isRefreshing = false
                showData(book)
                showRecyclerView(book.result.Related_by_book)
            } else {
                refreshDetailBook.isRefreshing = false
                Toast.makeText(this, "Jaringan Lemah, Silahkan Refresh!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showData(book: DetailBookResponse) {
        Glide.with(this)
            .load(Constans.API_URL + Constans.API_IMAGE + book.result.cover_url + Constans.API_KEY)
            .into(imgBook)
        jdlBuku.text = book.result.title
        namaPengarang.text = book.result.Writer_by_writer_id.User_by_user_id.name
        txtCategory.text = book.result.genres[0].title
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtSinopsisBook.text = Html.fromHtml(book.result.synopsis, Html.FROM_HTML_MODE_COMPACT)
        } else {
            txtSinopsisBook.text = Html.fromHtml(book.result.synopsis)
        }
        idPenulis = book.result.Writer_by_writer_id.User_by_user_id.id.toString()
    }

    private fun showRecyclerView(item: List<RelatedByBook>) {
        rvDetailBookRelated.adapter = RelatedBookAdapter(item)
    }
}
