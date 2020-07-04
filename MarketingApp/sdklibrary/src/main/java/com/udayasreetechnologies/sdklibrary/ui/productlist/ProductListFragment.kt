package com.udayasreetechnologies.sdklibrary.ui.productlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.ProductMainAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductListFragment : Fragment(), ProductMainAdapter.OnProductMainAdapterListener {

    private var mContext : Context? = null
    private lateinit var mListener : OnHomeFragmentListener
    private lateinit var mRecyclerView : RecyclerView

    private lateinit var mAdapter : ProductMainAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductListFragment().apply {
                /*arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }*/
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mContext = context
            mListener = context as OnHomeFragmentListener
        } catch (e : Exception) {
            throw ClassCastException(context.toString().plus(" must implement HomeFragment Listener"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_productlist, container, false)
        if (mContext != null) {
            initView(view)
        } else {
            mListener.onContextFailedListener()
        }
        return view
    }

    private fun initView(view: View) {
        mRecyclerView = view.findViewById(R.id.frag_home_recyclerview_id)

        val layoutManager = GridLayoutManager(mContext, 2, RecyclerView.VERTICAL, false)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when(position) {
                    0 , 1 -> {
                        2
                    }
                    else -> {
                        1
                    }
                }
            }
        }
        mRecyclerView.layoutManager = layoutManager
        mAdapter = ProductMainAdapter(mContext!!, this)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    override fun onAddToCartClickListener() {
        mListener.onAddToCartUpdateListener()
    }

    interface OnHomeFragmentListener {
        fun onContextFailedListener()
        fun onAddToCartUpdateListener()
    }
}