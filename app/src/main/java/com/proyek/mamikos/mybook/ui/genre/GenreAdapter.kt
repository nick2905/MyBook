package com.proyek.mamikos.mybook.ui.genre

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.Resource
import com.proyek.mamikos.mybook.ui.detailCategory.DetailGenreActivity
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(private val listGenre: List<Resource>) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {
    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(genre: Resource) {
            with(itemView) {
                genreTitle.text = genre.title
                bookCount.text = context.getString(R.string.x_book, genre.count.toString())
                itemView.setOnClickListener {
                    val intent = Intent(this.context, DetailGenreActivity::class.java)
                    intent.putExtra("idGenre", genre.id.toString())
                    context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
        GenreViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_genre, parent, false
            )
        )

    override fun getItemCount(): Int = listGenre.size

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(listGenre[position])
    }
}