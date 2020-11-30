package com.example.android.onestbrands.data.models

import androidx.room.ColumnInfo
import java.io.Serializable

data class Brand(
    @ColumnInfo(name = "brand_id") val id: Long,
    @ColumnInfo(name = "brand_name") val name: String,
    @ColumnInfo(name = "brand_short_name") val shortName: String
): Serializable

data class Category(
    @ColumnInfo(name = "category_id") val id: Long,
    @ColumnInfo(name = "category_name") val name: String): Serializable

data class Shop(
    @ColumnInfo(name = "shop_brand_id") val brandId: Long,
    @ColumnInfo(name = "shop_id") val id: Long,
    @ColumnInfo(name = "shop_latitude") val latitude: Double,
    @ColumnInfo(name = "shop_longitude") val longitude: Double): Serializable


data class ShopGG(
    @ColumnInfo(name = "brand_id") val brandId: Long,
    @ColumnInfo(name = "brand_name") val brandName: String,
    @ColumnInfo(name = "brand_short_name") val brandShortName: String,
    @ColumnInfo(name = "category_id") val categoryId: Long,
    @ColumnInfo(name = "category_name") val categoryName: String,
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double): Serializable