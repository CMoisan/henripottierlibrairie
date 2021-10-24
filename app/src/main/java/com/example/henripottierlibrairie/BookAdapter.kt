package com.example.henripottierlibrairie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso

class BookAdapter(private val books: List<Book>): Adapter<BookAdapter.BookPreview>() {
    class BookPreview(view: View) : RecyclerView.ViewHolder(view) {
        val couv: AppCompatImageView = view.findViewById(R.id.bookImg)
        val titre: TextView = view.findViewById(R.id.bookTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookPreview {
        val child = LayoutInflater.from(parent.context).inflate(R.layout.preview_book, parent, false)
        return BookPreview(child)
    }

    override fun onBindViewHolder(child: BookPreview, pos: Int) {
        Picasso.get().load(books[pos].cover).into(child.couv)
        child.titre.text = books[pos].title
    }

    override fun getItemCount() = books.size
}