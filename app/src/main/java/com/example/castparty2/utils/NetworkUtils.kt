package com.example.castparty2.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.castparty2.model.Episode
import com.example.castparty2.model.Podcast
import org.json.JSONArray
import org.json.JSONObject

// https://stackoverflow.com/questions/51141970/check-internet-connectivity-android-in-kotlin
fun isNetworkAvailable(context: Context?): Boolean {
    if (context == null) return false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                return true
            }
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                return true
            }
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                return true
            }
        }
    }
    return false
}

fun parseBestPodcastJsonResults(jsonResult: JSONObject): ArrayList<Podcast> {
    val podcastList = ArrayList<Podcast>()

    val podcasts = jsonResult.getJSONArray("podcasts")
    for (i in 0 until podcasts.length()) {
        Log.d("MainViewModel", podcasts[i].toString())
        val podcastJson = podcasts.getJSONObject(i)
        val id = podcastJson.getString("id")
        val title = podcastJson.getString("title")
        val description = podcastJson.getString("description")
        val publisher = podcastJson.getString("publisher")
        val image = podcastJson.getString("image")
        val thumbnail = podcastJson.getString("thumbnail")
        val totalEpisodes = podcastJson.getInt("total_episodes")
        val episodes = parseEpisodeJsonResults(podcastJson.getJSONArray("episodes"))
        val podcast =
            Podcast(id, title, description, publisher, image, thumbnail, totalEpisodes, episodes)
        podcastList.add(podcast)
    }
    return podcastList
}


//fun parseCuratedPodcastJsonResults(jsonResult: JSONObject): ArrayList<CuratedList> {
//    val podcastList = ArrayList<CuratedList>()
//    val curatedLists = jsonResult.getJSONArray("curated_lists")
//    for (i in 0 until curatedLists.length()) {
//        val series = curatedLists.getJSONObject(i)
//        val id = series.getString("id")
//        val title = series.getString("title")
//        val total = series.getInt("total")
//        podcastList.add(CuratedList(id, title, total))
//    }
//    return podcastList
//}
//
//fun parsePodcastJsonResults(jsonResult: JSONObject): Podcast {
//    val id = jsonResult.getString("id")
//    val title = jsonResult.getString("title")
//    val publisher = jsonResult.getString("publisher")
//    val image = jsonResult.getString("image")
//    val thumbnail = jsonResult.getString("thumbnail")
//    val url = jsonResult.getString("listennotes_url")
//    val totalEpisodes = jsonResult.getInt("total_episodes")
//    val episodesIdList = ArrayList<String>()
//    val episodesListJson = jsonResult.getJSONArray("episodes")
//    for (i in 0 until episodesListJson.length()) {
//        val episode = episodesListJson.getJSONObject(i)
//        val episodeId = episode.getString("id")
//        episodesIdList.add(episodeId)
//    }
//
//    return Podcast(id, title, publisher, image, thumbnail, url, totalEpisodes)
//}


fun parseEpisodeJsonResults(jsonResult: JSONArray): ArrayList<Episode> {
    val episodesList = ArrayList<Episode>()
    for (i in 0 until jsonResult.length()) {
        Log.d("MainViewModel", jsonResult[i].toString())
        val episodeJson = jsonResult.getJSONObject(i)
        val id = episodeJson.getString("id")
        val title = episodeJson.getString("title")
        val link = episodeJson.getString("link")
        val audio = episodeJson.getString("audio")
        val image = episodeJson.getString("image")
        val thumbnail = episodeJson.getString("thumbnail")
        val description = episodeJson.getString("description")
        val audioLengthSec = episodeJson.getInt("audio_length_sec")
        episodesList.add(
            Episode(
                id,
                title,
                link,
                audio,
                image,
                thumbnail,
                description,
                audioLengthSec
            )
        )

    }
    return episodesList
}