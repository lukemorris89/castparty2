package com.example.castparty2.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("parent_id")
    @Expose
    val parentId: Int
)

data class CategoryList(
    @SerializedName("genres")
    val categories: List<Category>? = null
)