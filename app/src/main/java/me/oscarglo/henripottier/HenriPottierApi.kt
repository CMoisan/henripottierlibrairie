package me.oscarglo.henripottier

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val api: HenriPottierApi = Retrofit.Builder()
    .baseUrl("https://henri-potier.techx.fr/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(HenriPottierApi::class.java)

interface HenriPottierApi {
    @GET("/books")
    fun getBooks(): Call<List<Book>>
}