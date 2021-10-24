package imt.oscarclemclem.henripottierlibrairie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Books(serviceRetrofit: Retrofit) : ViewModel() {
    val service = serviceRetrofit.create(BookManagementApi::class.java)

    private val books: MutableLiveData<List<Book>> by lazy {
        MutableLiveData<List<Book>>().also { loadBooks() }
    }

    fun getBooks(): LiveData<List<Book>> {
        return books
    }

    private fun loadBooks() {
        service.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                books.value = response.body()
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.v("TAG", "abouboubou")
            }
        })

    }

    interface OnBookClickedListener {
        fun onClick(book: Book?)
    }
}