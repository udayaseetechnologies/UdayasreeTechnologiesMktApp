package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smarteist.autoimageslider.SliderViewAdapter
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class HomeImageSliderAdapter(val context : Context, val sliderImageList : List<String>) : SliderViewAdapter<HomeImageSliderAdapter.ProductImageSliderHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?): ProductImageSliderHolder {
        return ProductImageSliderHolder(LayoutInflater.from(parent?.context).inflate(R.layout.row_product_imageslider,
            parent, false))
    }

    override fun getCount(): Int {
        return sliderImageList.size
    }

    override fun onBindViewHolder(holder: ProductImageSliderHolder?, position: Int) {

        val requestOption = RequestOptions()
            .placeholder(R.drawable.icon_category_placeholder)
            .error(R.drawable.icon_category_placeholder)

        holder?.imageSlider?.let {
            Glide.with(context)
                .setDefaultRequestOptions(requestOption)
                .load(sliderImageList[position])
                .fitCenter()
                .into(it)
        }
    }

    inner class ProductImageSliderHolder(view : View) : SliderViewAdapter.ViewHolder(view) {
        val imageSlider : ImageView = view.findViewById(R.id.row_slider_auto_image_slider)
        val text : USTextView = view.findViewById(R.id.row_slider_text)
    }
}