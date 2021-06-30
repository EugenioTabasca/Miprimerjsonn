package com.example.jsonporfavor.Interface

import com.example.jsonporfavor.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}