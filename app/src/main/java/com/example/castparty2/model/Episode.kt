package com.example.castparty2.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = "episodes")
data class Episode(
    @PrimaryKey
    override val id: String,
    override val title: String,
    val link: String,
    val audio: String,
    override val image: String,
    val thumbnail: String,
    val description: String,
    @SerializedName("audio_length_sec")
    val audioLengthSec: Int,
    var podcastId: String? = null,
    var downloadId: Long? = null
) : Content