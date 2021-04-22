package com.example.castparty2.datasource.remote;

import com.example.castparty2.model.BestPodcastsList
import com.example.castparty2.model.Category
import com.example.castparty2.model.CategoryList
import com.example.castparty2.model.Podcast
import com.example.castparty2.network.PodcastApi
import retrofit2.Call

class RemoteDataSource {
    private val podcastApiService = PodcastApi.retrofitService

    fun downloadPodcasts(): Call<BestPodcastsList> {
        return podcastApiService.getPodcasts()
    }

    fun downloadPodcastById(podcastId: String): Call<Podcast> {
        return podcastApiService.getPodcastById(id = podcastId)
    }

//    fun getEpisodesList(podcastId: String) = getResult {
//        podcastApiService.getEpisodesList(id = podcastId)
//    }
//
//     fun getCuratedLists(): LiveData<ApiResponse<BaseRequest>>  {
//        podcastApiService.getCuratedPodcasts()
//    }
//
//    fun getEpisodes(podcastId: String): LiveData<ApiResponse<EpisodeListRequest>> {
//        podcastApiService.getEpisodesList(id = podcastId)
//    }
//
//    suspend fun getEpisodeById(episodeId: String) = getResult {
//        podcastApiService.getEpisodeInfo(id = episodeId)
//    }

    fun downloadCategories(): Call<CategoryList> {
        return podcastApiService.getCategories()
    }
}
