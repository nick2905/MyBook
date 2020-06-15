package com.proyek.mamikos.mybook.ui.genre

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.Resource
import com.proyek.mamikos.mybook.ui.newbook.BukuBaruActivity
import com.proyek.mamikos.mybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var genreViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGenreBook.setHasFixedSize(true)
        rvGenreBook.layoutManager = GridLayoutManager(this, 2)

        refreshMainActivity.setOnRefreshListener {
            refreshMainActivity.isRefreshing = true
            showRecyclerView()
        }

        lnrBukuBaru.setOnClickListener {
            startActivity(Intent(this, BukuBaruActivity::class.java))
        }

        dumpDataLoading.visibility = View.VISIBLE
        refreshMainActivity.isRefreshing = true
        showRecyclerView()
    }

    private fun showRecyclerView() {
        genreViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        genreViewModel.getAllGenre()
        genreViewModel.setDataGenre().observe(this, Observer { genre ->
            if (genre != null) {
                dumpDataLoading.visibility = View.GONE
                refreshMainActivity.isRefreshing = false
                var listAllData = genre.resource
                showData(listAllData)

            } else {
                dumpDataLoading.visibility = View.INVISIBLE
                refreshMainActivity.isRefreshing = false
                Toast.makeText(this, "Jaringan Lemah, Coba Refresh!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showData(genre: List<Resource>) {
        rvGenreBook.adapter = GenreAdapter(genre)
    }
}
