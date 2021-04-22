package com.example.castparty2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.castparty2.model.Category
import com.example.castparty2.model.Episode
import com.example.castparty2.model.Podcast
import com.example.castparty2.model.Session
import com.example.castparty2.utils.Converters

@Database(
    entities = [Podcast::class, Episode::class, Session::class, Category::class],
    version = 8,
    exportSchema = true
)

@TypeConverters(Converters::class)

abstract class CastParty2DB : RoomDatabase() {
    abstract fun podcastDao(): PodcastDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun sessionDao(): SessionDao
    abstract fun categoryDao(): CategoryDao
}