package com.example.castparty2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.castparty.model.Episode
import com.example.castparty.model.Podcast

@Entity
data class Session(
    @PrimaryKey
    val sessionId: String,
    val podcast: Podcast,
    val episode: Episode
)