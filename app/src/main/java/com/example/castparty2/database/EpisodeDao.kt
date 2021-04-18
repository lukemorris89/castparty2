package com.example.castparty2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.castparty2.model.Episode

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episodes WHERE id = :episodeId")
    fun getEpisodeById(episodeId: String): Episode?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodes(episodes: List<Episode>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisode(episode: Episode)

    @Query("DELETE FROM episodes")
    fun deleteAllEpisodes()

    @Query("DELETE FROM episodes WHERE id = :episodeId")
    fun deleteEpisodeById(episodeId: String)

    @Query("SELECT COUNT(*) FROM episodes")
    fun getCountEpisodes(): Int
}