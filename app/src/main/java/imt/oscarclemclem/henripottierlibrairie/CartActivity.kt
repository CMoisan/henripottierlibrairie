package imt.oscarclemclem.henripottierlibrairie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_content)

        val recyclerView: RecyclerView = findViewById(R.id.CartRecyclerView)
        val adapter = CartAdapter(MainActivity.shopping_cart)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }
}