package com.vk.mathaplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "http://numbersapi.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiRemoteService {
    @GET("{yearValue}/year")
    fun getYearFact(@Path("yearValue")yearValue: Int): Call<String>
    @GET("{number}/math")
    fun getMathFact(@Path("number")number: Int): Call<String>

    @GET("{month}/{date}/date")
    fun getDateFact(@Path("month")month: Int, @Path("date")date: Int): Call<String>

    @GET("{number}")
    fun getTriviaFact(@Path("number")number: Int): Call<String>

}
val remoteService : ApiRemoteService by lazy {
    retrofit.create(ApiRemoteService::class.java) }