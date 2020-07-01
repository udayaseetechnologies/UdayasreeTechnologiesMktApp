package com.udayasreetechnologies.sdklibrary.ui.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class ProductListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val IMAGE_SLIDER = 0
    private val PRODUCT_CATEGORY = 1
    private val PRODUCT_LIST = 2

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                IMAGE_SLIDER
            }
            1 -> {
                PRODUCT_CATEGORY
            }
            else -> {
                PRODUCT_LIST
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            IMAGE_SLIDER -> {
                ProductSliderHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_slider_productlist,
                    parent, false))
            }

            PRODUCT_CATEGORY -> {
                ProductCategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_category_productlist,
                    parent, false))
            }

            PRODUCT_LIST -> {
                ProductListHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_productlist_view,
                    parent, false))
            }

            else -> {
                null!!
            }
        }
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            IMAGE_SLIDER -> {
                val sHolder = ProductSliderHolder(holder.itemView)

            }

            PRODUCT_CATEGORY -> {
                val cHolder = ProductCategoryHolder(holder.itemView)
                cHolder.categoryRecyclerView
            }

            PRODUCT_LIST -> {
                val lHolder = ProductListHolder(holder.itemView)
            }
        }
    }

    inner class ProductListHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage : ImageView = view.findViewById(R.id.row_productlist_image_id)
        val productTitle : USTextView = view.findViewById(R.id.row_productlist_title_id)
        val productSubtitle : USTextView = view.findViewById(R.id.row_productlist_subtitle_id)
        private val addToCartAction : USTextView = view.findViewById(R.id.row_productlist_addtocart_aciton)

        init {
            addToCartAction.setOnClickListener {

            }
        }
    }

    inner class ProductCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryRecyclerView : RecyclerView = view.findViewById(R.id.row_category_productlist_recycler)
    }

    inner class ProductSliderHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}