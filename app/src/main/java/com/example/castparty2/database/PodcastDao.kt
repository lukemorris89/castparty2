package com.example.castparty2.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.castparty2.model.Podcast

@Dao
interface PodcastDao {

    @Query("SELECT * FROM podcasts")
    fun getPodcasts(): List<Podcast>

    @Query("SELECT * FROM podcasts WHERE id = :podcastId")
    fun getPodcastById(podcastId: String): Podcast?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPodcasts(podcasts: List<Podcast>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPodcast(podcast: Podcast)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePodcast(podcast: Podcast)

    @Query("DELETE FROM podcasts WHERE id = :podcastId")
    fun deletePodcastById(podcastId: String)

    @Query("DELETE FROM podcasts")
    fun deleteAllPodcasts()

    @Query("SELECT COUNT(*) FROM podcasts")
    fun getCountPodcasts(): Int

    @Query("SELECT * FROM podcasts WHERE favourite IS 1")
    fun observeFavourites(): LiveData<List<Podcast>>

    @Query("SELECT COUNT(episodes) FROM podcasts WHERE id = :podcastId")
    fun getCountEpisodesByPodcastId(podcastId: String): Int

    @Query("SELECT * FROM podcasts WHERE id = :podcastId")
    fun getEpisodesByPodcastId(podcastId: String): Podcast
}