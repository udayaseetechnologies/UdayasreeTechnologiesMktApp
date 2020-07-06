package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.ProductCategoryAdapter
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.ProductImageSliderAdapter
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.DeleteResponse
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView


class ProductMainAdapter(val context : Context, val response : ArrayList<DeleteResponse>,  val listener : OnProductMainAdapterListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
                ProductSliderHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_product_imageslider_main,
                    parent, false))
            }

            PRODUCT_CATEGORY -> {
                ProductCategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_product_category_main,
                    parent, false))
            }

            PRODUCT_LIST -> {
                ProductListHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_product_main,
                    parent, false))
            }

            else -> {
                null!!
            }
        }
    }

    override fun getItemCount(): Int {
        return response.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            IMAGE_SLIDER -> {
                val sHolder = ProductSliderHolder(holder.itemView)
                sHolder.imageSlider.setSliderAdapter(ProductImageSliderAdapter(context, response[position].bannerImages))
                sHolder.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
                sHolder.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
                sHolder.imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
                sHolder.imageSlider.scrollTimeInSec = 3
                sHolder.imageSlider.startAutoCycle()
            }

            PRODUCT_CATEGORY -> {
                val cHolder = ProductCategoryHolder(holder.itemView)
                cHolder.categoryRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                val cAdapter = ProductCategoryAdapter(context, response[position].category)
                cHolder.categoryRecyclerView.setHasFixedSize(true)
                cHolder.categoryRecyclerView.adapter = cAdapter
                cAdapter.notifyDataSetChanged()
            }

            PRODUCT_LIST -> {
                val lHolder = ProductListHolder(holder.itemView)
                val model = response[position]
                val requestOption = RequestOptions()
                    .placeholder(R.drawable.icon_category_placeholder)
                    .error(R.drawable.icon_category_placeholder)

                lHolder?.productImage?.let {
                    Glide.with(context)
                        .setDefaultRequestOptions(requestOption)
                        .load(model.productImage)
                        .fitCenter()
                        .into(it)
                }
                lHolder.productTitle.text = model.productName
            }
        }
    }

    inner class ProductListHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage : ImageView = view.findViewById(R.id.row_productlist_image_id)
        val productTitle : USTextView = view.findViewById(R.id.row_productlist_title_id)
        val productPrice : USTextView = view.findViewById(R.id.row_productlist_price)
        private val addToCartAction : USTextView = view.findViewById(R.id.row_productlist_addtocart_aciton)

        init {
            productImage.layoutParams.height = (AppUtility.SCREEN_WIDTH * 0.30).toInt()
            addToCartAction.setOnClickListener {
                listener.onAddToCartClickListener()
            }
        }
    }

    inner class ProductCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryRecyclerView : RecyclerView = view.findViewById(R.id.row_category_productlist_recycler)
        init {
            //categoryRecyclerView.layoutParams.height = (AppUtility.SCREEN_HEIGHT * 0.10).toInt()
        }
    }

    inner class ProductSliderHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageSlider : SliderView = view.findViewById(R.id.row_product_imageSlider)
        init {
            imageSlider.layoutParams.height = (AppUtility.SCREEN_HEIGHT * 0.30).toInt()
        }
    }

    interface OnProductMainAdapterListener {
        fun onAddToCartClickListener()
    }
}