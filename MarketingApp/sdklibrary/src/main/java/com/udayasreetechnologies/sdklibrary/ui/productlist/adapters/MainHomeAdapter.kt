package com.udayasreetechnologies.sdklibrary.ui.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.models.MainHomeModel
import com.udayasreetechnologies.sdklibrary.utils.GridSpacingItemDecorator
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility


class MainHomeAdapter(
    val context: Context, val mainHomeList: List<MainHomeModel>,
    val listenerHome: OnMainHomeAdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), HomeProductAdapter.OHomeProductAdapterListener {

    private val SLIDER_VIEW = 1
    private val HORIZONTAL_VIEW = 2
    private val VERTICAL_VIEW = 3
    private val VERTICAL_2GRID_VIEW = 4
    private val VERTICAL_3GRID_VIEW = 5

    override fun getItemViewType(position: Int): Int {
        return when (mainHomeList[position].viewType) {
            SLIDER_VIEW -> {
                SLIDER_VIEW
            }
            HORIZONTAL_VIEW -> {
                HORIZONTAL_VIEW
            }
            VERTICAL_VIEW -> {
                VERTICAL_VIEW
            }
            VERTICAL_2GRID_VIEW -> {
                VERTICAL_2GRID_VIEW
            }
            VERTICAL_3GRID_VIEW -> {
                VERTICAL_3GRID_VIEW
            }
            else -> {
                VERTICAL_VIEW
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SLIDER_VIEW -> {
                ProductSliderHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.row_product_imageslider_main,
                        parent, false
                    )
                )
            }

            HORIZONTAL_VIEW -> {
                ProductCategoryHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.row_product_category_main,
                        parent, false
                    )
                )
            }

            VERTICAL_2GRID_VIEW -> {
                ProductCategoryHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.row_product_category_main,
                        parent, false
                    )
                )
            }

            else -> {
                null!!
            }
        }
    }

    override fun getItemCount(): Int {
        return mainHomeList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            SLIDER_VIEW -> {
                val sHolder = ProductSliderHolder(holder.itemView)
                sHolder.imageSlider.setSliderAdapter(
                    HomeImageSliderAdapter(
                        context,
                        mainHomeList[position].sliderImage
                    )
                )
                sHolder.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
                sHolder.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
                sHolder.imageSlider.autoCycleDirection =
                    SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
                sHolder.imageSlider.scrollTimeInSec = 3
                sHolder.imageSlider.startAutoCycle()
            }

            HORIZONTAL_VIEW -> {
                val cHolder = ProductCategoryHolder(holder.itemView)
                cHolder.categoryAndProductRecyclerView.layoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                val cAdapter = HomeCategoryAdapter(context, mainHomeList[position].categories)
                cHolder.categoryAndProductRecyclerView.setHasFixedSize(true)
                cHolder.categoryAndProductRecyclerView.adapter = cAdapter
                cAdapter.notifyDataSetChanged()
            }

            VERTICAL_VIEW -> {
                val cHolder = ProductCategoryHolder(holder.itemView)
                cHolder.categoryAndProductRecyclerView.layoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                val cAdapter = HomeCategoryAdapter(context, mainHomeList[position].categories)
                cHolder.categoryAndProductRecyclerView.setHasFixedSize(true)
                cHolder.categoryAndProductRecyclerView.adapter = cAdapter
                cAdapter.notifyDataSetChanged()
            }

            VERTICAL_2GRID_VIEW -> {
                val lHolder = ProductCategoryHolder(holder.itemView)

                lHolder.categoryAndProductRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
                val lAdapter = HomeProductAdapter(context, mainHomeList[position].products, this)
                lHolder.categoryAndProductRecyclerView.setHasFixedSize(true)
                lHolder.categoryAndProductRecyclerView.addItemDecoration(GridSpacingItemDecorator(10))
                lHolder.categoryAndProductRecyclerView.adapter = lAdapter
                lAdapter.notifyDataSetChanged()
            }

            VERTICAL_3GRID_VIEW -> {
                val lHolder = ProductCategoryHolder(holder.itemView)

                lHolder.categoryAndProductRecyclerView.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
                val lAdapter = HomeProductAdapter(context, mainHomeList[position].products, this)
                lHolder.categoryAndProductRecyclerView.setHasFixedSize(true)
                lHolder.categoryAndProductRecyclerView.addItemDecoration(GridSpacingItemDecorator(10))
                lHolder.categoryAndProductRecyclerView.adapter = lAdapter
                lAdapter.notifyDataSetChanged()
            }
        }
    }

    inner class ProductCategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryAndProductRecyclerView: RecyclerView = view.findViewById(R.id.row_category_productlist_recycler)
    }

    inner class ProductSliderHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageSlider: SliderView = view.findViewById(R.id.row_product_imageSlider)

        init {
            imageSlider.layoutParams.height = (AppUtility.SCREEN_HEIGHT * 0.30).toInt()
        }
    }


    override fun onAddToCartClickListener() {
        listenerHome.onAddToCartClickListener()
    }

    interface OnMainHomeAdapterListener {
        fun onAddToCartClickListener()
        fun onWishListUpdateListener(position: Int, isWishList: Boolean)
    }
}