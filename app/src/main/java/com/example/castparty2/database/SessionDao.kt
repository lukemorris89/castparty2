package com.example.castparty2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.castparty2.model.Episode
import com.example.castparty2.model.Session

@Dao
interface SessionDao {

    @Query("SELECT sessionId FROM session")
    fun getAllSessionIds(): List<String>

    @Query("SELECT episode FROM session WHERE sessionId = :sessionId")
    fun getEpisodeBySessionId(sessionId: String): Episode

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertSession(session: Session)

    @Query("DELETE FROM session WHERE sessionId = :sessionId")
    fun deleteSession(sessionId: String)

}