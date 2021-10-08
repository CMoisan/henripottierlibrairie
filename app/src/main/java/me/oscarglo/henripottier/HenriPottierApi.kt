package me.oscarglo.henripottier

import retrofit2.Call
import retrofit2.http.GET

interface HenriPottierApi {
    @GET("/books")
    suspend fun getBooks(): List<Book>
}