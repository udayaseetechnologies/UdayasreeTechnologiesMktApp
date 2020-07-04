package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.CircleImageView
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class ProductCategoryAdapter : RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryHolder {
        return ProductCategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_product_category,
            parent, false))
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ProductCategoryHolder, position: Int) {
        holder.circularView.setImageResource(R.drawable.icon_category_placeholder)
    }

    inner class ProductCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val circularView : CircleImageView = view.findViewById(R.id.row_product_category_image)
        val title : USTextView = view.findViewById(R.id.row_product_category_title)

        init {
            circularView.layoutParams.width = (AppUtility.SCREEN_WIDTH * 0.15).toInt()
            circularView.layoutParams.height = (AppUtility.SCREEN_WIDTH * 0.15).toInt()
        }
    }
}