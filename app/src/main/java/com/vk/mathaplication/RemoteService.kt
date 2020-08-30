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
}
val remoteService : ApiRemoteService by lazy {
    retrofit.create(ApiRemoteService::class.java) }