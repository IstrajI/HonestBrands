package com.example.android.onestbrands.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.onestbrands.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFeatureFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager.adapter = HomePagerAdapter(requireContext(), parentFragmentManager)
        tabs.setupWithViewPager(viewPager)
    }
}