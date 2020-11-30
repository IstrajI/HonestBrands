package com.example.android.onestbrands

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.android.onestbrands.data.dao.HonestBrandsDatabase
import com.example.android.onestbrands.ui.home.HomeFeatureFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Navigator {
    lateinit var database: HonestBrandsDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database =
            Room.databaseBuilder(
                applicationContext,
                HonestBrandsDatabase::class.java,
                "HonestBrands.db")
                .fallbackToDestructiveMigration()
                .createFromAsset("brands.db")
                .build()

        startFeature(HomeFeatureFragment::class.java, Bundle())
    }

    override fun <T: Fragment> startFeature(clazz: Class<T>, data: Bundle) {
        val fragment = clazz.newInstance()
        fragment.arguments = data
        supportFragmentManager.beginTransaction().replace(
            container.id,
            fragment
        ).commit()
    }
}

interface Navigator {
    fun <T: Fragment> startFeature (clazz: Class<T>, data: Bundle)
}