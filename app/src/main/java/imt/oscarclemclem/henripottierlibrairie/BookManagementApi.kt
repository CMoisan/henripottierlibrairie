package imt.oscarclemclem.henripottierlibrairie

import retrofit2.Call
import retrofit2.http.GET

interface BookManagementApi {
    @GET("books")
    fun getBooks(): Call<List<Book>>
}