package me.oscarglo.henripottier

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import java.lang.NullPointerException

typealias Books = Result<List<Book>>

class BookStore : ViewModel() {
    val books: MutableLiveData<Books> by lazy {
        MutableLiveData<Books>().also { loadBooks() }
    }

    private fun loadBooks() {
        api.getBooks().enqueue(object: Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val body = response.body() ?: return onFailure(call, NullPointerException())
                books.value = Result.success(body)
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                books.value = Result.failure(t)
            }
        })
    }
}