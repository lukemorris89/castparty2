package com.example.castparty2.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
@Entity(
    tableName = "podcasts"
)
data class Podcast(
    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: String,
    @ColumnInfo(name = "title")
    override val title: String,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "publisher")
    val publisher: String?,
    @ColumnInfo(name = "image")
    override val image: String?,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String?,
    @SerializedName("total_episodes")
    @ColumnInfo(name = "total_episodes")
    val total: Int,
    @ColumnInfo(name = "episodes")
    var episodes: MutableList<Episode?>,
    @ColumnInfo(name = "favourite")
    var favourite: Boolean = false
) : Content

data class BestPodcastsList(
    val id: String,
    val podcasts: List<Podcast>
)