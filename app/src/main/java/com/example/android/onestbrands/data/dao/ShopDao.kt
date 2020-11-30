package com.example.android.onestbrands.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.android.onestbrands.data.models.Shop

@Dao
interface ShopDao {
/*    @Transaction
    @Query("SELECT brand.id AS brand_id, brand.name AS brand_name, brand.short_name AS brand_short_name, category.name AS category_name, category.id AS category_id, shop.id AS id, shop.latitude, shop.longitude FROM shop LEFT JOIN brand ON shop.brand_id = brand.id LEFT JOIN category ON brand.category_id = category.id")
    fun getAll(): LiveData<List<ShopGG>>*/

    @Query("SELECT shop.id AS shop_id, shop.brand_id AS shop_brand_id, shop.latitude AS shop_latitude, shop.longitude AS shop_longitude FROM shop")
    fun getAll(): LiveData<List<Shop>>
}
