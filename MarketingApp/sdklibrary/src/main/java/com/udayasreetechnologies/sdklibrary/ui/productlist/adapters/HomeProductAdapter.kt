package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.models.HomeProductModel
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class HomeProductAdapter(val context : Context, val productList : List<HomeProductModel>, val listener : OHomeProductAdapterListener) : RecyclerView.Adapter<HomeProductAdapter.HomeProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductHolder {
        return HomeProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_product_main , parent, false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: HomeProductHolder, position: Int) {

        val model = productList[position]
        val requestOption = RequestOptions()
            .placeholder(R.drawable.icon_category_placeholder)
            .error(R.drawable.icon_category_placeholder)

        holder?.productImage?.let {
            Glide.with(context)
                .setDefaultRequestOptions(requestOption)
                .load(model.productImage)
                .fitCenter()
                .into(it)
        }

        holder.productTitle.text = model.productName
        holder.productPrice.text = "Rs.180"

        /*holder.productWishlist.setImageDrawable(
            if (model.wishList){
                ContextCompat.getDrawable(context, R.drawable.ic_wishlist_24dp)
            } else {
                ContextCompat.getDrawable(context, R.drawable.ic_unwishllist_24dp)
            }
        )

        holder.productWishlist.setOnClickListener {
            val isWishList = !(response[position].wishList)
            holder.productWishlist.setImageDrawable(
                if (isWishList){
                    ContextCompat.getDrawable(context, R.drawable.ic_wishlist_24dp)
                } else {
                    ContextCompat.getDrawable(context, R.drawable.ic_unwishllist_24dp)
                }
            )
        }*/
    }

    inner class HomeProductHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.row_productlist_image_id)
        val productTitle: USTextView = view.findViewById(R.id.row_productlist_title_id)
        val productPrice: USTextView = view.findViewById(R.id.row_productlist_price)
        val productWishlist: ImageView = view.findViewById(R.id.row_productlist_wishlist_action)
        private val addToCartAction: USTextView = view.findViewById(R.id.row_productlist_addtocart_aciton)

        init {
            productImage.layoutParams.height = (AppUtility.SCREEN_WIDTH * 0.30).toInt()

            addToCartAction.setOnClickListener {
                listener.onAddToCartClickListener()
            }
        }
    }

    interface OHomeProductAdapterListener {
        fun onAddToCartClickListener()
    }
}