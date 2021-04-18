package com.example.castparty2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Session(
    @PrimaryKey
    val sessionId: String,
    val podcast: Podcast,
    val episode: Episode
)