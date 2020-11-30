package com.example.android.onestbrands.ui.home.map

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.example.android.onestbrands.MainActivity
import com.example.android.onestbrands.R
import com.example.android.onestbrands.ui.HomeViewModelFactory
import com.example.android.onestbrands.ui.home.HomeViewModel
import com.google.android.libraries.maps.*
import com.google.android.libraries.maps.model.*
import kotlinx.android.synthetic.main.map_fragment.*

class MapFragment : Fragment() {
    val viewModel: HomeViewModel by activityViewModels { HomeViewModelFactory(database = (activity as MainActivity).database) }
    companion object {
        val BRAND_KEY = "BRAND_KEY"
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.map_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        map.onCreate(savedInstanceState ?: Bundle())
        map.onResume()
        MapsInitializer.initialize(context)
        map.cameraDistance = 12f
        map.getMapAsync { map ->
            map.setOnInfoWindowClickListener { marker-> Toast.makeText(requireContext(), "hello darling", Toast.LENGTH_SHORT).show() }
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(53.893009, 27.567444), 13f))
            viewModel.shops.observe(viewLifecycleOwner) { shops ->
                map?.let {
                    shops.map {shop ->
                        map.addMarker(MarkerOptions().apply {
                            position(LatLng(shop.latitude, shop.longitude))

                            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_shop)
                            drawable!!.setBounds(0,0, drawable.intrinsicWidth, drawable.intrinsicHeight)
                            val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
                            val canvas = Canvas(bitmap)
                            drawable.draw(canvas)
                            icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                        })
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        map.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map.onLowMemory()
    }

    override fun onStart() {
        super.onStart()
        map.onStart()
    }

    override fun onStop() {
        super.onStop()
        map.onStop()
    }
}