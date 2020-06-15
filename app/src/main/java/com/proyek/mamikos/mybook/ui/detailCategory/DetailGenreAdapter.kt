package com.proyek.mamikos.mybook.ui.detailCategory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.Result
import com.proyek.mamikos.mybook.ui.detailBook.DetailBookActivity
import com.proyek.mamikos.mybook.utils.Constans
import kotlinx.android.synthetic.main.item_book_genre.view.*

class DetailGenreAdapter(private val listBook: List<Result>) :
    RecyclerView.Adapter<DetailGenreAdapter.DetailGenreViewHolder>() {

    inner class DetailGenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Result) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(Constans.API_URL + Constans.API_IMAGE + book.cover_url + Constans.API_KEY)
                    .into(imgBook)
                txtJudulBook.text = book.title
                txtNamePengarang.text = book.Writer_by_writer_id.User_by_user_id.name
                idReadBook.text = book.view_count.toString()
                itemView.setOnClickListener {
                    val intent = Intent(this.context, DetailBookActivity::class.java)
                    intent.putExtra("idBooks", book.id.toString())
                    context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailGenreViewHolder =
        DetailGenreViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book_genre, parent, false
            )
        )

    override fun getItemCount(): Int = listBook.size

    override fun onBindViewHolder(holder: DetailGenreViewHolder, position: Int) {
        holder.bind(listBook[position])
    }

}