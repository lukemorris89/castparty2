package com.example.castparty2.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.castparty2.database.DataRepository
import com.example.castparty2.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _categoryListLD = MutableLiveData<List<Category>>()
    val categoryListLD: LiveData<List<Category>>
        get() = _categoryListLD

    private val _podcastList = MutableLiveData<List<Podcast>>()
    val podcastList: LiveData<List<Podcast>>
        get() = _podcastList

    private val _episodeList = MutableLiveData<List<Episode>>()
    val episodeList: LiveData<List<Episode>>
        get() = _episodeList

    init {
        if (dataRepository.getCountPodcasts() == 0) {
            downloadPodcasts()
        } else {
            _podcastList.value = dataRepository.getPodcasts()
        }
    }

    private fun downloadPodcasts() {
        val call = dataRepository.downloadPodcasts()
        call.enqueue(object : Callback<BestPodcastsList> {
            override fun onResponse(
                call: Call<BestPodcastsList>,
                response: Response<BestPodcastsList>
            ) {
                Log.d(TAG, response.body().toString())
                val podcasts = response.body()?.podcasts
                if (podcasts != null) {
                    podcasts.forEach {
                        it.episodes = ArrayList()
                    }
                    _podcastList.value = podcasts
                    dataRepository.insertPodcasts(podcasts)
                }
            }

            override fun onFailure(call: Call<BestPodcastsList>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }
        })
    }

    private fun getCategories() {
        if (dataRepository.getCountCategories() == 0) {
            val call = dataRepository.downloadCategories()
            call.enqueue(object: Callback<CategoryList> {
                override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                    Log.e(TAG, t.message.toString())
                }

                override fun onResponse(
                    call: Call<CategoryList>,
                    response: Response<CategoryList>
                ) {
                    Log.d(TAG, response.raw().toString())
                    _categoryListLD.value = (response.body()?.categories ?: return)
                    response.body()?.categories?.let { dataRepository.insertCategories(it) }
                }

            })
        } else {
            _categoryListLD.value = dataRepository.getCategories()
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}