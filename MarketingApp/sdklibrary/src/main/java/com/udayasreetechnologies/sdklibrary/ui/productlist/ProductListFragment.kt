package com.udayasreetechnologies.sdklibrary.ui.productlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductListFragment : Fragment() {

    private var mContext : Context? = null
    private lateinit var mListener : OnHomeFragmentListener
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mSortSpinner : Spinner

    private lateinit var mAdapter : ProductListAdapter

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
        mSortSpinner = view.findViewById(R.id.frag_home_sort_spinner_id)
        mRecyclerView = view.findViewById(R.id.frag_home_recyclerview_id)

        mRecyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mAdapter = ProductListAdapter()
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    interface OnHomeFragmentListener {
        fun onContextFailedListener()
    }
}