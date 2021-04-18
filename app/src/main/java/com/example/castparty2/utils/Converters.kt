package com.example.castparty2.utils

import androidx.room.TypeConverter
import com.example.castparty2.model.Episode
import com.example.castparty2.model.Podcast
import com.example.castparty2.model.Session
import com.google.gson.GsonBuilder

class Converters {

    val gson = GsonBuilder().create()

    @TypeConverter
    fun listStringToJson(value: List<String>?) = gson.toJson(value)

    @TypeConverter
    fun jsonToListString(value: String?) = gson.fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun podcastToJson(value: Podcast) = gson.toJson(value)

    @TypeConverter
    fun jsonToPodcast(value: String) =
        gson.fromJson(value, Podcast::class.java)

    @TypeConverter
    fun listPodcastToJson(value: List<Podcast>?) = gson.toJson(value)

    @TypeConverter
    fun jsonToListPodcast(value: String) =
        gson.fromJson(value, Array<Podcast>::class.java).toMutableList()

    @TypeConverter
    fun listEpisodeToJson(value: List<Episode>) = gson.toJson(value)

    @TypeConverter
    fun jsonToListEpisode(value: String) =
        gson.fromJson(value, Array<Episode>::class.java).toMutableList()

    @TypeConverter
    fun EpisodeToJson(value: Episode) = gson.toJson(value)

    @TypeConverter
    fun jsonToEpisode(value: String) =
        gson.fromJson(value, Episode::class.java)

    @TypeConverter
    fun jsonToSession(value: String) =
        gson.fromJson(value, Session::class.java)
}
