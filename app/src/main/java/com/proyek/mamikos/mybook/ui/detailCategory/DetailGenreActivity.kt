package com.proyek.mamikos.mybook.ui.detailCategory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.Result
import com.proyek.mamikos.mybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_detail_genre.*

class DetailGenreActivity : AppCompatActivity() {
    private lateinit var detailGenreViewModel: BookViewModel
    lateinit var idGenre: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_genre)

        idGenre = intent.getStringExtra("idGenre")

        rvDetailGenre.setHasFixedSize(true)
        rvDetailGenre.layoutManager = GridLayoutManager(this, 2)

        refreshDetailGenre.setOnRefreshListener {
            refreshDetailGenre.isRefreshing = true
            showRecyclerView(idGenre)
        }

        refreshDetailGenre.isRefreshing = true
        showRecyclerView(idGenre)

    }

    private fun showRecyclerView(idGenre: String) {
        detailGenreViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        detailGenreViewModel.getAllBookCategory(idGenre)
        detailGenreViewModel.setDataCategoryBook().observe(this, Observer { book ->
            if (book != null) {
                refreshDetailGenre.isRefreshing = false
                showData(book.result)
            } else {
                refreshDetailGenre.isRefreshing = false
                Toast.makeText(this, "Jaringan Lemah, Coba Refresh!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showData(detail: List<Result>) {
        rvDetailGenre.adapter = DetailGenreAdapter(detail)
    }
}
