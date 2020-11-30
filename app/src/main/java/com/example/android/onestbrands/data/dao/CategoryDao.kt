package com.example.android.onestbrands.data.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAll(): List<CategoryDBModel>
}
