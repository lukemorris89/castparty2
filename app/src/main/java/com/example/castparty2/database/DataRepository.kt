package com.example.castparty2.database

import androidx.lifecycle.LiveData
import com.example.castparty2.datasource.local.LocalDataSource
import com.example.castparty2.datasource.remote.RemoteDataSource
import com.example.castparty2.model.*
import retrofit2.Call

class DataRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) {

    fun getPodcasts(): List<Podcast> {
        return localDataSource.getPodcasts()
    }

    fun getPodcastById(podcastId: String): Podcast? {
        return localDataSource.getPodcastById(podcastId)
    }

    fun insertPodcast(podcast: Podcast) {
        localDataSource.insertPodcast(podcast)
    }

    fun insertPodcasts(podcasts: List<Podcast>) {
        localDataSource.insertPodcasts(podcasts)
    }

    fun updatePodcast(podcast: Podcast) {
        localDataSource.updatePodcast(podcast)
    }

    fun deletePodcastById(podcastId: String) {
        localDataSource.deletePodcastById(podcastId)
    }

    fun deleteAllPodcasts() {
        localDataSource.deleteAllPodcasts()
    }

    fun getCountPodcasts(): Int {
        return localDataSource.getCountPodcasts()
    }

    fun getEpisodesByPodcastId(podcastId: String): Podcast {
        return localDataSource.getEpisodesByPodcastId(podcastId)
    }

    fun insertEpisodes(episodes: List<Episode>) {
        localDataSource.insertEpisodes(episodes)
    }

    fun updateEpisode(episode: Episode) {
        localDataSource.insertEpisode(episode)
    }

    fun getCountEpisodesByPodcastId(podcastId: String): Int {
        return localDataSource.getCountEpisodesByPodcastId(podcastId)
    }

    fun downloadPodcasts(): Call<BestPodcastsList> {
        return remoteDataSource.downloadPodcasts()
    }

    fun downloadPodcastById(podcastId: String): Call<Podcast> {
        return remoteDataSource.downloadPodcastById(podcastId)
    }
//
//    fun getCuratedList(shouldFetch: Boolean = false): LiveData<Resource<CuratedListResponse>> {
//        return object :
//            NetworkBoundResource<CuratedListResponse, BaseRequest>(appExecutors) {
//            override fun saveCallResult(item: BaseRequest) {
//            }
//
//            override fun shouldFetch(data: CuratedListResponse?) = data == null || shouldFetch
//
//            override fun loadFromDb(): LiveData<CuratedListResponse> =
//                localDataSource.getCuratedLists()
//
//            override fun createCall() = remoteDataSource.getCuratedLists()
//        }.asLiveData()
//    }
//
    fun observeFavourites(): LiveData<List<Podcast>> {
        return localDataSource.observeFavourites()
    }

    fun createSession(session: Session) {
        localDataSource.createSession(session)
    }

    fun getAllSessionIds(): List<String> {
        return localDataSource.getAllSessionIds()
    }

    fun getCountCategories(): Int {
        return localDataSource.getCountCategories()
    }

    fun getCategories(): List<Category> {
        return localDataSource.getCategories()
    }

    fun downloadCategories(): Call<CategoryList> {
        return remoteDataSource.downloadCategories()
    }

    fun insertCategories(categories: List<Category>) {
        return localDataSource.insertCategories(categories)
    }
}