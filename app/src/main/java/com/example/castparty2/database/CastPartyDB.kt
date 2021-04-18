package com.example.castparty2.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.castparty.model.Episode
import com.example.castparty2.model.Podcast
import com.example.castparty2.model.Session

@Database(
    entities = [Podcast::class, Episode::class, Session::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)

abstract class CastPartyDB : RoomDatabase() {
    abstract fun podcastDao(): PodcastDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun sessionDao(): SessionDao
}