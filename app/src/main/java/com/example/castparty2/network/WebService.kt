package com.example.castparty2.network

import com.example.castparty2.BuildConfig
import com.example.castparty2.model.BestPodcastsList
import com.example.castparty2.model.Episode
import com.example.castparty2.model.Podcast
import com.example.castparty2.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface WebService {
    @GET("best_podcasts")
    fun getPodcasts(
        @Header("X-ListenAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Query("genre") genreId: Int? = null
    ): Call<BestPodcastsList>

    @GET("podcasts/{id}")
    fun getPodcastById(
        @Header("X-ListenAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Path("id") id: String
    ): Call<Podcast>

    @GET("search")
    suspend fun searchPodcasts(
        @Header("X-ListenAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Query("q") searchQuery: String
    ): Call<List<Podcast>>

    @GET("episodes/{id}")
    suspend fun getPodcastEpisodeInfo(
        @Header("X-ListenAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Path("id") id: String
    ): Call<Episode>

    @GET("podcasts/{id}/recommendations")
    suspend fun getRecommendedEpisodes(
        @Header("X-ListenAPI-Key") apiKey: String = BuildConfig.API_KEY,
        @Path("id") id: String
    ): Call<String>

}

object PodcastApi {
    val retrofitService: WebService by lazy {
        retrofit.create(WebService::class.java)
    }
}