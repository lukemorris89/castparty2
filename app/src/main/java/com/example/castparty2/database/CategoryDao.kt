package com.example.castparty2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.castparty2.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: List<Category>)

    @Query("SELECT COUNT(*) FROM categories")
    fun getCountCategories(): Int
}