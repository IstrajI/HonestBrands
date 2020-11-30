package com.example.android.onestbrands.ui.home.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.onestbrands.MainActivity
import com.example.android.onestbrands.ui.home.map.MapFragment
import com.example.android.onestbrands.Navigator
import com.example.android.onestbrands.R
import com.example.android.onestbrands.data.models.Brand
import com.example.android.onestbrands.ui.HomeViewModelFactory
import com.example.android.onestbrands.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.brand_list_fragment.*

class BrandListFeatureFragment : Fragment() {
    private val viewModel: HomeViewModel by activityViewModels { HomeViewModelFactory(database = (activity as MainActivity).database) }
    lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navigator = activity as Navigator
        return LayoutInflater.from(activity).inflate(R.layout.brand_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        brandsList.layoutManager = GridLayoutManager(activity, 3)
        val adapter = BrandListAdapter(requireContext(), object : BrandListAdapter.ItemClickListener {
            override fun onItemClick(brand: Brand) {
                navigator.startFeature(clazz = MapFragment::class.java,
                    data = Bundle().apply {
                        putSerializable(MapFragment.BRAND_KEY, brand)
                    })
            }
        })
        brandsList.adapter = adapter
        viewModel.brand.observe(viewLifecycleOwner) {
            Log.d("TestPish", "${it}")
            adapter.update(it)
        }
    }
}