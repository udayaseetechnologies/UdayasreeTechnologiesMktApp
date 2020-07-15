package com.udayasreetechnologies.sdklibrary.ui.productlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.utils.GridSpacingItemDecorator
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.ProductMainAdapter
import com.udayasreetechnologies.utilitylibrary.customuiview.CategoryProduct
import com.udayasreetechnologies.utilitylibrary.customuiview.DeleteResponse

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductListFragment : Fragment(), ProductMainAdapter.OnProductMainAdapterListener {

    private var mContext : Context? = null
    private lateinit var mListener : OnHomeFragmentListener
    private lateinit var mRecyclerView : RecyclerView

    private lateinit var mAdapter : ProductMainAdapter

    companion object {
        @JvmStatic
        fun newInstance() = ProductListFragment().apply {
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
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.addItemDecoration(GridSpacingItemDecorator(10))
        mAdapter = ProductMainAdapter(mContext!!, createResponse(), this)
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


    private fun createResponse() : ArrayList<DeleteResponse>  {
        val response = ArrayList<DeleteResponse>()

        val sliderList = ArrayList<String>()
        sliderList.add("https://c.ndtvimg.com/2019-06/6r7r9j38_healthy-summer-diet-fruit-salad_625x300_17_June_19.jpg")
        sliderList.add("https://c.ndtvimg.com/2019-11/2kakjdo8_fruits_625x300_27_November_19.jpg")
        sliderList.add("https://images.pexels.com/photos/1132047/pexels-photo-1132047.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
        sliderList.add("https://images.pexels.com/photos/1128678/pexels-photo-1128678.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")

        val category = ArrayList<CategoryProduct>()
        category.add(CategoryProduct("Apple's", "https://images.pexels.com/photos/209339/pexels-photo-209339.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200", ""))
        category.add(CategoryProduct("Strawberries","https://images.pexels.com/photos/89778/strawberries-frisch-ripe-sweet-89778.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200",""))
        category.add(CategoryProduct("Banana's","https://images.pexels.com/photos/61127/pexels-photo-61127.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200",""))
        category.add(CategoryProduct("Orange's","https://images.pexels.com/photos/51958/oranges-fruit-vitamins-healthy-eating-51958.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200",""))
        category.add(CategoryProduct("Cherry's","https://images.pexels.com/photos/1178610/pexels-photo-1178610.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200",""))
        category.add(CategoryProduct("Custard Apple's","https://images.pexels.com/photos/214168/pexels-photo-214168.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200",""))
        category.add(CategoryProduct("Raspberry's","https://images.pexels.com/photos/59999/raspberries-fruits-fruit-berries-59999.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=200",""))

        response.add(DeleteResponse(sliderList, ArrayList<CategoryProduct>(), "", "", ""))
        response.add(DeleteResponse(ArrayList<String>(), category, "", "", ""))

        response.add(DeleteResponse(ArrayList<String>(), ArrayList<CategoryProduct>(),
            "Red Apple", "https://images.pexels.com/photos/206959/pexels-photo-206959.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100", ""))
        response.add(DeleteResponse(ArrayList<String>(), ArrayList<CategoryProduct>(),
            "Green Apple", "https://images.pexels.com/photos/38068/pexels-photo-38068.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100", ""))
        response.add(DeleteResponse(ArrayList<String>(), ArrayList<CategoryProduct>(),
            "Orange", "https://images.pexels.com/photos/161559/background-bitter-breakfast-bright-161559.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100", ""))
        response.add(DeleteResponse(ArrayList<String>(), ArrayList<CategoryProduct>(),
            "Pinapple", "https://images.pexels.com/photos/137119/pexels-photo-137119.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100", ""))
        response.add(DeleteResponse(ArrayList<String>(), ArrayList<CategoryProduct>(),
            "Kiwi", "https://images.pexels.com/photos/54370/pexels-photo-54370.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100", ""))
        response.add(DeleteResponse(ArrayList<String>(), ArrayList<CategoryProduct>(),
            "Watermelon", "https://images.pexels.com/photos/1313267/pexels-photo-1313267.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100", ""))

        return response
    }
}