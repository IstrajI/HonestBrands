package com.example.android.onestbrands.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.onestbrands.data.dao.HonestBrandsDatabase
import com.example.android.onestbrands.data.models.Brand
import com.example.android.onestbrands.data.models.Shop

class HomeViewModel(database: HonestBrandsDatabase) : ViewModel() {
    var brand: LiveData<List<Brand>> = database.brandDao().getAll()
    var shops: LiveData<List<Shop>> = database.shopDao().getAll()
}