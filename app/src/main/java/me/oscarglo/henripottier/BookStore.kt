package me.oscarglo.henripottier

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class BookStore(retrofit: Retrofit) : ViewModel() {
    val service = retrofit.create(HenriPottierApi::class.java)

    private val books: MutableLiveData<Result<List<Book>>> by lazy {
        MutableLiveData<Result<List<Book>>>().also { loadBooks() }
    }

    fun getUsers(): LiveData<Result<List<Book>>> {
        return books
    }

    private fun loadBooks() {
        viewModelScope.launch {
            books.value = service.runCatching { getBooks() }
        }
    }
}