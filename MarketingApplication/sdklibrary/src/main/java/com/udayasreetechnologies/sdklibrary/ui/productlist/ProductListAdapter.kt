package com.udayasreetechnologies.sdklibrary.ui.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListHolder {
        return ProductListHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_productlist_view, parent, false))
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ProductListHolder, position: Int) {

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
}