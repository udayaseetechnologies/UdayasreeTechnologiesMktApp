package com.udayasreetechnologies.sdklibrary.ui.productdetail

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.SliderView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class ProductDetailActivity : AppCompatActivity(), View.OnClickListener {

    private var quantityCount = 1

    private lateinit var locationText : USTextView
    private lateinit var imageSliderView : SliderView
    private lateinit var wishListImageView : ImageView

    private lateinit var quantityRecycler : RecyclerView
    private lateinit var quantityRecyclerContainer : LinearLayout

    private lateinit var quantityCountContainer : LinearLayout
    private lateinit var countPlusAction : ImageView
    private lateinit var countMinusAction : ImageView
    private lateinit var countTextView : USTextView

    private lateinit var addToCartAction : USTextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //ThemeColors(this)
        setContentView(R.layout.activity_product_detail)

        initView()
    }

    private fun initView() {
        locationText = findViewById(R.id.product_detail_location_id)
        imageSliderView = findViewById(R.id.product_detail_imageSlider_id)
        wishListImageView = findViewById(R.id.product_detail_wishlist_action)

        quantityRecycler = findViewById(R.id.product_detail_quantity_type_recycler)
        quantityRecyclerContainer = findViewById(R.id.product_detail_recycler_quantity_container)

        quantityCountContainer = findViewById(R.id.product_detail_count_quantity_container)
        countMinusAction = findViewById(R.id.product_detail_count_minus_action)
        countPlusAction = findViewById(R.id.product_detail_count_plus_action)
        countTextView = findViewById(R.id.product_detail_count_text_id)

        addToCartAction = findViewById(R.id.product_detail_addToCart_id)

        countTextView.layoutParams.width = (AppUtility.SCREEN_WIDTH * 0.1).toInt()

        countTextView.text = quantityCount.toString()

        wishListImageView.setOnClickListener(this)
        countMinusAction.setOnClickListener(this)
        countPlusAction.setOnClickListener(this)
        addToCartAction.setOnClickListener(this)
    }

    private fun updateQuantityCount(isPlus : Boolean) {
        if (quantityCount > 1) {
            if (isPlus) {
                quantityCount++
            } else {
                quantityCount--
            }
        }
        countTextView.text = quantityCount.toString()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.product_detail_wishlist_action -> {
                /*TODO: wish list action*/
            }

            R.id.product_detail_count_minus_action -> {
                /*TODO: Minus Click action*/
                updateQuantityCount(false)
            }

            R.id.product_detail_count_plus_action -> {
                /*TODO: Plus Click Action*/
                updateQuantityCount(true)
            }

            R.id.product_detail_addToCart_id -> {
                /*TODO: Add to cart action*/
            }
        }
    }
}