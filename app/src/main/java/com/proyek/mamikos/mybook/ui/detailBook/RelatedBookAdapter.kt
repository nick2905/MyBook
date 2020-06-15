package com.proyek.mamikos.mybook.ui.detailBook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyek.mamikos.mybook.R
import com.proyek.mamikos.mybook.model.RelatedByBook
import com.proyek.mamikos.mybook.utils.Constans
import kotlinx.android.synthetic.main.item_book.view.*

class RelatedBookAdapter(private val listRelatedBook: List<RelatedByBook>) :
    RecyclerView.Adapter<RelatedBookAdapter.RelatedViewHolder>() {
    inner class RelatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: RelatedByBook) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(Constans.API_URL + Constans.API_IMAGE + book.cover_url + Constans.API_KEY)
                    .into(itemImgBook)
                judulBook.text = book.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder =
        RelatedViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book, parent, false
            )
        )

    override fun getItemCount(): Int = listRelatedBook.size

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        holder.bind(listRelatedBook[position])
    }

}