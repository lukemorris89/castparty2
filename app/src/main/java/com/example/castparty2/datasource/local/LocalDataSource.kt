package com.example.castparty2.datasource.local;

import androidx.lifecycle.LiveData
import com.example.castparty2.model.Episode
import com.example.castparty2.database.CastParty2DB
import com.example.castparty2.model.Podcast
import com.example.castparty2.model.Session

class LocalDataSource internal constructor(
    database: CastParty2DB
) {

    private val podcastDao = database.podcastDao()
    private val episodeDao = database.episodeDao()
    private val sessionDao = database.sessionDao()

    fun getPodcasts(): List<Podcast> {
        return podcastDao.getPodcasts()
    }

    fun getPodcastById(podcastId: String): Podcast? {
        return podcastDao.getPodcastById(podcastId)
    }

    fun insertPodcast(podcast: Podcast) {
        podcastDao.insertPodcast(podcast)
    }

    fun insertPodcasts(podcasts: List<Podcast>) {
        podcastDao.insertPodcasts(podcasts)
    }

    fun deletePodcastById(podcastId: String) {
        podcastDao.deletePodcastById(podcastId)
    }

    fun deleteAllPodcasts() {
        podcastDao.deleteAllPodcasts()
    }

    fun getCountPodcasts(): Int {
        return podcastDao.getCountPodcasts()
    }

    fun updatePodcast(podcast: Podcast) {
        podcastDao.updatePodcast(podcast)
    }

    fun observeFavourites(): LiveData<List<Podcast>> {
        return podcastDao.observeFavourites()
    }

    fun getEpisodesByPodcastId(podcastId: String): Podcast {
        return podcastDao.getEpisodesByPodcastId(podcastId)
    }

    fun getCountEpisodesByPodcastId(podcastId: String): Int {
        return podcastDao.getCountEpisodesByPodcastId(podcastId)
    }

    fun insertEpisode(episode: Episode) {
        episodeDao.insertEpisode(episode)
    }

    fun insertEpisodes(episodes: List<Episode>) {
        episodeDao.insertEpisodes(episodes)
    }

    fun getEpisodeById(episodeId: String): Episode? {
        return episodeDao.getEpisodeById(episodeId)
    }

    fun deleteAllEpisodes() {
        episodeDao.deleteAllEpisodes()
    }

    fun deleteEpisodeById(episodeId: String) {
        episodeDao.deleteEpisodeById(episodeId)
    }

    fun createSession(session: Session) {
        sessionDao.insertSession(session)
    }

    fun getAllSessionIds(): List<String> {
        return sessionDao.getAllSessionIds()
    }
}
