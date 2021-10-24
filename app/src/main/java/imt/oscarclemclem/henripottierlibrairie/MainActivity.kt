package imt.oscarclemclem.henripottierlibrairie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var service: BookManagementApi
    lateinit var url: Url

    companion object {
        const val BASE_URL = "https://henri-potier.techx.fr/"
        var shopping_cart = ArrayList<Book>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cart: ImageView = this.findViewById(R.id.cartIcon)
        cart.setOnClickListener {
            val intent = Intent(this@MainActivity, CartActivity::class.java)
            startActivity(intent)
        }

        val request = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = Books(request)
        val result = service.getBooks()
        result.observe(this) { res ->
            val recyclerView: RecyclerView = findViewById(R.id.booksView)
            val adapter = BookAdapter(res)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerView.addOnItemTouchListener(
                RecyclerListener(this, object : RecyclerListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Log.d("TAG", "Test  Touch " + res[position].title)
                        Log.d("TAG", "TEST PANIER " + shopping_cart.size)
                        val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                            putExtra("1", res[position])
                        }
                        startActivity(intent)
                    }
                })
            )
        }
    }
}