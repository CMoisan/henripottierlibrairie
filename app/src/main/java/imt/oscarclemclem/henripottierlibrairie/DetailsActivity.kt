package imt.oscarclemclem.henripottierlibrairie

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    private var current: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        current = intent.getSerializableExtra("1") as Book?
        //val current : Book = Book("","",1,"https://firebasestorage.googleapis.com/v0/b/henri-potier.appspot.com/o/hp0.jpg?alt=media",Array<String>(5) { "CC" })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details)
        val est = intent.extras

        Log.d("TAG", "Test  Extras " + est)


        val bookTitle = findViewById<TextView>(R.id.bookTitle).apply {
            text = current?.title

        }
        val bookPrice = findViewById<TextView>(R.id.bookPrice).apply {
            text = current?.price.toString()
        }
        val bookSynopsis = findViewById<TextView>(R.id.bookSynopsis).apply {
            text = current?.synopsis?.joinToString()
        }
        val bookIsbn = findViewById<TextView>(R.id.bookIsbn).apply {
            text = current?.isbn
        }
        val bookImage = findViewById<AppCompatImageView>(R.id.bookImg).apply {
            Picasso.get().load(current?.cover).into(this)
        }

        val buyButton = findViewById<Button>(R.id.buyButton)
        buyButton.setOnClickListener {
            onBuyClick()
        }
    }

    fun onBuyClick() {
        Log.d("TAG", "Test PANIER 1 " + MainActivity.shopping_cart.size)
        current?.let { MainActivity.shopping_cart.add(it) }
        Log.d("TAG", "Test PANIER 2 " + MainActivity.shopping_cart.size)
    }
}