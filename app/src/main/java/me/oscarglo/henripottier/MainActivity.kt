package me.oscarglo.henripottier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    companion object {
        val LOGID = "henripottier"
        val SERVICE_URL = "https://henri-potier.techx.fr/"
    }

    private lateinit var service: HenriPottierApi
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = BookStore(retrofit)
        service.getUsers().observe(this) { res ->
            // Check result state
            val books = res.getOrThrow()

            val recyclerView: RecyclerView = findViewById(R.id.bookList)
            recyclerView.adapter = BookAdapter(books)
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
}