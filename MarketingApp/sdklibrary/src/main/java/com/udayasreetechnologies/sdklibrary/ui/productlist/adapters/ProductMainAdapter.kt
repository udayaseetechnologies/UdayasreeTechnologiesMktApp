package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.ProductCategoryAdapter
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.ProductImageSliderAdapter
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView


class ProductMainAdapter(val context : Context, val listener : OnProductMainAdapterListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val IMAGE_SLIDER = 0
    private val PRODUCT_CATEGORY = 1
    private val PRODUCT_LIST = 2

    private val sliderList = ArrayList<String>()
    init {
        sliderList.add("https://c.ndtvimg.com/2019-06/6r7r9j38_healthy-summer-diet-fruit-salad_625x300_17_June_19.jpg")
        sliderList.add("https://c.ndtvimg.com/2019-06/6r7r9j38_healthy-summer-diet-fruit-salad_625x300_17_June_19.jpg")
        sliderList.add("https://c.ndtvimg.com/2019-06/6r7r9j38_healthy-summer-diet-fruit-salad_625x300_17_June_19.jpg")
        sliderList.add("https://c.ndtvimg.com/2019-06/6r7r9j38_healthy-summer-diet-fruit-salad_625x300_17_June_19.jpg")
    }

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
        return 8
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            IMAGE_SLIDER -> {
                val sHolder = ProductSliderHolder(holder.itemView)
                sHolder.imageSlider.setSliderAdapter(ProductImageSliderAdapter(context, sliderList))
                sHolder.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
                sHolder.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
                sHolder.imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
                sHolder.imageSlider.scrollTimeInSec = 3
                sHolder.imageSlider.startAutoCycle()
            }

            PRODUCT_CATEGORY -> {
                val cHolder = ProductCategoryHolder(holder.itemView)
                cHolder.categoryRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                val cAdapter = ProductCategoryAdapter()
                cHolder.categoryRecyclerView.adapter = cAdapter
                cAdapter.notifyDataSetChanged()
            }

            PRODUCT_LIST -> {
                val lHolder = ProductListHolder(holder.itemView)
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