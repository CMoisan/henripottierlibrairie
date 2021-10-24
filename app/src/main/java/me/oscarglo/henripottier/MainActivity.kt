package me.oscarglo.henripottier

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val LOGID = "henripottier"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.bookList)
        recyclerView.adapter = BookAdapter()
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)

        val bookStore: BookStore by viewModels()
        bookStore.books.observe(this) { res ->
            Log.d(LOGID, "observe: $res")
            val adapter = recyclerView.adapter as BookAdapter
            adapter.books = res.getOrThrow()
        }
    }
}