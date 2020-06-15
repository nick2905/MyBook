package com.proyek.mamikos.mybook.ui.newbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.Result
import com.proyek.mamikos.mybook.model.ResultNew
import com.proyek.mamikos.mybook.ui.detailCategory.DetailGenreAdapter
import com.proyek.mamikos.mybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_buku_baru.*

class BukuBaruActivity : AppCompatActivity() {
    private lateinit var detailGenreViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buku_baru)

        rvDetailGenre.setHasFixedSize(true)
        rvDetailGenre.layoutManager = GridLayoutManager(this, 2)

        refreshDetailGenre.setOnRefreshListener {
            refreshDetailGenre.isRefreshing = true
            showRecyclerView()
        }

        refreshDetailGenre.isRefreshing = true
        showRecyclerView()
    }

    private fun showRecyclerView() {
        detailGenreViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        detailGenreViewModel.getBookUpTodate()
        detailGenreViewModel.setDataNewBook().observe(this, Observer { book ->
            if (book != null) {
                refreshDetailGenre.isRefreshing = false
                showData(book.result)
            } else {
                refreshDetailGenre.isRefreshing = false
                Toast.makeText(this, "Jaringan Lemah, Coba Refresh!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showData(detail: List<ResultNew>) {
        rvDetailGenre.adapter = DetailNewAdapter(detail)
    }
}
