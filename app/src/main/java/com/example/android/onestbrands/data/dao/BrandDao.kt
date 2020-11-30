package com.example.android.onestbrands.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.onestbrands.data.models.Brand
import com.example.android.onestbrands.data.models.Shop

@Dao
interface BrandDao {
/*    @Query("SELECT brand.id, brand.name, brand.short_name, category.name AS category_name, category.id AS category_id, shop.id AS shop_id, shop.latitude AS shop_latitude, shop.longitude AS shop_longitude  FROM brand LEFT JOIN category ON category.id = brand.category_id LEFT JOIN shop ON shop.brand_id = brand.id")
    @Transaction
    fun getBrandsWithCategoryName(): LiveData<List<Brand>>*/

    @Query("SELECT brand.id AS brand_id, brand.name AS brand_name, brand.short_name AS brand_short_name FROM brand")
    fun getAll(): LiveData<List<Brand>>
}
