package me.oscarglo.henripottier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso

class BookAdapter : Adapter<BookAdapter.BookPreview>() {
    var books: List<Book> = listOf()

    class BookPreview(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.bookPreviewImg)
        val title: TextView = view.findViewById(R.id.bookPreviewTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookPreview {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_preview, parent, false)

        return BookPreview(view)
    }

    override fun onBindViewHolder(view: BookPreview, pos: Int) {
        Picasso.get().load(books[pos].cover).into(view.image)
        view.title.text = books[pos].title
    }

    override fun getItemCount() = books.size
}