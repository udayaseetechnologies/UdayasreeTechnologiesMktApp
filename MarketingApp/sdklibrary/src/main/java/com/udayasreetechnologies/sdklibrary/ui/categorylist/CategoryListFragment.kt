package com.udayasreetechnologies.sdklibrary.ui.categorylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CategoryListFragment : Fragment() {

    private lateinit var categoryRecycler : RecyclerView

    companion object {
        @JvmStatic
        fun newInstance() = CategoryListFragment().apply {
            /*arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }*/
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        categoryRecycler = view.findViewById(R.id.category_list_recycler_id)
    }
}