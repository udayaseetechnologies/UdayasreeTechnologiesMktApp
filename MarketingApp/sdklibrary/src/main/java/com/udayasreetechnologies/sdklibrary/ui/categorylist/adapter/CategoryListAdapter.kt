package com.udayasreetechnologies.sdklibrary.ui.categorylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class CategoryListAdapter : RecyclerView.Adapter<CategoryListAdapter.CategoryListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        return CategoryListHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_category_main, parent, false))
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {

    }

    inner class CategoryListHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val container : LinearLayout = view.findViewById(R.id.row_categorylist_container_action)
        val imageView : ImageView = view.findViewById(R.id.row_categorylist_image_id)
        val title : USTextView = view.findViewById(R.id.row_categorylist_title_id)

        init {
            container.setOnClickListener(this)
            imageView.setOnClickListener(this)
            title.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            /*TODO: Get Product of category from here*/
        }
    }
}