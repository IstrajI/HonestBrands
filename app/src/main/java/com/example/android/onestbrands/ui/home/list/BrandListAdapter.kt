package com.example.android.onestbrands.ui.home.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android.onestbrands.R
import com.example.android.onestbrands.data.models.Brand
import kotlinx.android.synthetic.main.brand_list_item.view.*

class BrandListAdapter(private val context: Context, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<BrandListAdapter.BrandViewHolder>() {
    private val brands: MutableList<Brand>? = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.brand_list_item, parent, false))
    }

    override fun getItemCount() = brands?.size ?: 0

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.itemView.name.text = brands!![position].name
        holder.itemView.image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.evroopt))
        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(brands[position])
        }
    }

    fun update(brands: List<Brand>) {
        this.brands!!.apply {
            clear()
            addAll(brands)
        }
        notifyDataSetChanged()
    }

    class BrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ItemClickListener {
        fun onItemClick(brand: Brand)
    }
}