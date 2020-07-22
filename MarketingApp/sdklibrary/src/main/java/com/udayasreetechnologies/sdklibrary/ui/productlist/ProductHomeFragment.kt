package com.udayasreetechnologies.sdklibrary.ui.productlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udayasreetechnologies.sdklibrary.utils.GridSpacingItemDecorator
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.retrofitpkg.ApiClient
import com.udayasreetechnologies.sdklibrary.retrofitpkg.ApiInterface
import com.udayasreetechnologies.sdklibrary.ui.productlist.adapters.MainHomeAdapter
import com.udayasreetechnologies.sdklibrary.ui.productlist.models.MainHomeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragmentHome : Fragment(), MainHomeAdapter.OnMainHomeAdapterListener {

    private var mContext : Context? = null
    private lateinit var mListener : OnHomeFragmentListener
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mHomeAdapter : MainHomeAdapter

    private val mainHomeAdapterListener : MainHomeAdapter.OnMainHomeAdapterListener = this

    companion object {
        @JvmStatic
        fun newInstance() = ListFragmentHome().apply {
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
        val view = inflater.inflate(R.layout.fragment_product_home, container, false)
        if (mContext != null) {
            initView(view)
        } else {
            mListener.onContextFailedListener()
        }
        return view
    }

    private fun initView(view: View) {
        mRecyclerView = view.findViewById(R.id.frag_home_recyclerview_id)

        /*val layoutManager = GridLayoutManager(mContext, 2, RecyclerView.VERTICAL, false)
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
        }*/

        getHomeProductApi()
    }

    override fun onAddToCartClickListener() {
        mListener.onAddToCartUpdateListener()
    }

    override fun onWishListUpdateListener(position : Int, isWishList : Boolean) {

    }

    interface OnHomeFragmentListener {
        fun onContextFailedListener()
        fun onAddToCartUpdateListener()
    }

/*------------------------------ RETROFIT LISTENER ---------------------------------*/
    private val mInterface = ApiClient.getApiClientDuplicate()?.create(ApiInterface::class.java)

    private var mainHomeList = ArrayList<MainHomeModel>()

    private fun getHomeProductApi() {
        val call = mInterface?.getDuplicateHomeProductApi()

        call?.enqueue(object : Callback<List<MainHomeModel>> {
            override fun onFailure(call: Call<List<MainHomeModel>>, t: Throwable) {
                Toast.makeText(mContext, "Failed to fetch data", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<MainHomeModel>>, response: Response<List<MainHomeModel>>) {
                if (response.isSuccessful && response.body() != null) {
                    mainHomeList = (response.body() as ArrayList<MainHomeModel>?)!!

                    mRecyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
                    mRecyclerView.setHasFixedSize(true)
                    //mRecyclerView.addItemDecoration(GridSpacingItemDecorator(10))
                    mHomeAdapter = MainHomeAdapter(mContext!!, mainHomeList, mainHomeAdapterListener)
                    mRecyclerView.adapter = mHomeAdapter
                    mHomeAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}