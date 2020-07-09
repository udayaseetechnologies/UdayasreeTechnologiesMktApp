package com.udayasreetechnologies.sdklibrary.retrofitpkg.apiutils

import android.content.Context
import android.content.SharedPreferences
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.retrofitpkg.ApiClient
import com.udayasreetechnologies.sdklibrary.retrofitpkg.ApiInterface
import com.udayasreetechnologies.sdklibrary.retrofitpkg.callbacks.OnHomeApiListener
import com.udayasreetechnologies.sdklibrary.retrofitpkg.callbacks.OnPostalQueryApiListener
import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.HomeMainModel
import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.PostalMainModel
import com.udayasreetechnologies.sdklibrary.utils.SharedPreferenceUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitUtils(private val mContext: Context) {

    val preference : SharedPreferenceUtils = SharedPreferenceUtils(mContext)
    val packageName : String = preference.getPackageName()!!
    val appVersion : String = preference.getPackageVersion()!!

    fun getPostalDetailResponseApi(postal : String, listener : OnPostalQueryApiListener) {
        val mInterface = ApiClient.getPostalApiClient()?.create(ApiInterface::class.java)
        val call = mInterface?.getPostalDetailApi("/api/pincode/$postal")
        call?.enqueue(object : Callback<PostalMainModel> {
            override fun onFailure(call: Call<PostalMainModel>, t: Throwable) {
                listener.onResponseFailed(t.message.toString())
            }
            override fun onResponse(call: Call<PostalMainModel>, response: Response<PostalMainModel>) {
                if (response.isSuccessful && response.body() != null) {
                    listener.onPostalQueryApiSuccessful(response.body()!!)
                } else {
                    listener.onResponseFailed(mContext.getString(R.string.response_fail))
                }
            }
        })
    }

    fun getHomeResponseApi(levelType : String, listener : OnHomeApiListener) {

        val mInterface = ApiClient.getApiClient()?.create(ApiInterface::class.java)
        val call = mInterface?.getHomeMainApi(ApiConstant.consumerKey, ApiConstant.consumerConstant,
            levelType, packageName, appVersion)

        call?.enqueue(object : Callback<HomeMainModel> {
            override fun onFailure(call: Call<HomeMainModel>, t: Throwable) {
                listener.onResponseFailed(t.message.toString())
            }
            override fun onResponse(call: Call<HomeMainModel>, response: Response<HomeMainModel>) {
                if (response.isSuccessful && response.body() != null) {
                    listener.onHomeApiSuccessful(response.body()!!)
                } else {
                    listener.onResponseFailed(mContext.getString(R.string.response_fail))
                }
            }
        })
    }

}