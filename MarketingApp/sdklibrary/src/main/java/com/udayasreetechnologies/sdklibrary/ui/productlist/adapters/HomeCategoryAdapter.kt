package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.models.HomeCategoryModel
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.CircleImageView
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class HomeCategoryAdapter(val context : Context, val categoryList : List<HomeCategoryModel>) : RecyclerView.Adapter<HomeCategoryAdapter.ProductCategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryHolder {
        return ProductCategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_product_category,
            parent, false))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ProductCategoryHolder, position: Int) {
        val model = categoryList[position]
        val requestOption = RequestOptions()
            .placeholder(R.drawable.icon_category_placeholder)
            .error(R.drawable.icon_category_placeholder)

        holder?.circularView?.let {
            Glide.with(context)
                .setDefaultRequestOptions(requestOption)
                .load(model.categoryImage)
                .fitCenter()
                .into(it)
        }
        holder.title.setText(model.categoryName)
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