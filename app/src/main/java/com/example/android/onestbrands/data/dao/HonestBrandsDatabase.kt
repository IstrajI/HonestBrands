package com.example.android.onestbrands.data.dao

import androidx.room.*

@Database(
    entities = [BrandDBModel::class, ShopDBModel::class, CategoryDBModel::class],
    version = 1,
    exportSchema = true
)
abstract class HonestBrandsDatabase : RoomDatabase() {
    abstract fun brandDao(): BrandDao
    abstract fun shopDao(): ShopDao
    abstract fun categoryDao(): CategoryDao
}

@Entity(
    tableName = "brand",
    foreignKeys = [ForeignKey(
        entity = CategoryDBModel::class,
        parentColumns = ["id"],
        childColumns = ["category_id"]
    )],
    indices = [Index("category_id")]
)
data class BrandDBModel(
    @PrimaryKey
    val id: Long,
    val name: String,
    @ColumnInfo(name = "category_id")
    val categoryId: Long,
    @ColumnInfo(name = "short_name")
    val shortName: String?
)

@Entity(tableName = "category")
data class CategoryDBModel(
    @PrimaryKey
    val id: Long,
    val name: String
)

@Entity(
    tableName = "shop",
    foreignKeys = [ForeignKey(
        entity = BrandDBModel::class,
        parentColumns = ["id"],
        childColumns = ["brand_id"]
    )],
    indices = [Index("brand_id")]
)
data class ShopDBModel(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "brand_id")
    val brandId: Long,
    val latitude: Double?,
    val longitude: Double?
)