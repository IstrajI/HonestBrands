package com.example.android.onestbrands.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.onestbrands.data.dao.HonestBrandsDatabase
import com.example.android.onestbrands.ui.home.HomeViewModel

class HomeViewModelFactory(val database: HonestBrandsDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HomeViewModel(database) as T
}