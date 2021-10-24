package com.example.henripottierlibrairie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val books: List<Book>): RecyclerView.Adapter<CartAdapter.CartPreview>() {
    class CartPreview(view: View) : RecyclerView.ViewHolder(view) {
        val titre: TextView = view.findViewById(R.id.bookTitre)
        val price: TextView = view.findViewById(R.id.bookPrice)
        val delete: ImageView = view.findViewById(R.id.trashIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartPreview {
        val child = LayoutInflater.from(parent.context).inflate(R.layout.book_line, parent, false)
        return CartPreview(child)
    }

    override fun onBindViewHolder(child: CartPreview, pos: Int) {
        child.titre.text = books[pos].title
        child.price.text = books[pos].price.toString()
        child.delete.setOnClickListener {
            MainActivity.shopping_cart.removeAt(pos)
        }
    }

    override fun getItemCount() = books.size

}