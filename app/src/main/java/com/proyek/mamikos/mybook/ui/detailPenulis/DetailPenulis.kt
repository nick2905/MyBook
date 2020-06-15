package com.proyek.mamikos.mybook.ui.detailPenulis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.ResultWriter
import com.proyek.mamikos.mybook.utils.Constans
import com.proyek.mamikos.mybook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_detail_penulis.*

class DetailPenulis : AppCompatActivity() {
    private lateinit var detailWritterViewModel: BookViewModel
    lateinit var idWritter: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penulis)

        idWritter = intent.getStringExtra("IdWritter")

        refreshPenulis.setOnRefreshListener {
            refreshPenulis.isRefreshing = true
            showAllDataPenulis(idWritter)
        }

        refreshPenulis.isRefreshing = true
        showAllDataPenulis(idWritter)
    }

    private fun showAllDataPenulis(idWritter: String) {
        detailWritterViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        detailWritterViewModel.getWriter(idWritter)
        detailWritterViewModel.setDataWritter().observe(this, Observer { writter ->
            if (writter != null) {
                refreshPenulis.isRefreshing = false
                showData(writter.result)
            } else {
                refreshPenulis.isRefreshing = false
                Toast.makeText(this, "Jaringan Lemah, Silahkan Refresh!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showData(writter: ResultWriter) {
        Glide.with(this)
            .load(Constans.API_URL + Constans.API_IMAGE + writter.photo_url + Constans.API_KEY)
            .into(imgPenulis)
        namaPenulis.text = writter.name
        emailPenulis.text = writter.email
        nomorPenulis.text = writter.phone
    }
}
