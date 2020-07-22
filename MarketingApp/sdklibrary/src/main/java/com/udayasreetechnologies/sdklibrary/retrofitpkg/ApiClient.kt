package com.udayasreetechnologies.sdklibrary.retrofitpkg


import com.udayasreetechnologies.sdklibrary.retrofitpkg.apiutils.ApiConstant
import com.udayasreetechnologies.sdklibrary.retrofitpkg.apiutils.URLUtility
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {

        @JvmField
        var retrofit : Retrofit? = null
        private var BASE_URL = URLUtility.SDK_BASE_URL

        private val okHttpClient = OkHttpClient.Builder()
            .readTimeout(180, TimeUnit.SECONDS)
            .connectTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Cache-Control", "no-store")
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()


        fun getApiClient() : Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return retrofit
        }


        private val POSTAL_BASE_URL = "http://www.postalpincode.in/"
        private var postalRetrofit : Retrofit? = null
        fun getPostalApiClient() : Retrofit? {
            if (postalRetrofit == null) {
                postalRetrofit = Retrofit.Builder()
                    .baseUrl(POSTAL_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return postalRetrofit
        }

        private val DUPLICATE = "https://api.jsonbin.io/"
        private var duplicateRetrofit : Retrofit? = null
        fun getApiClientDuplicate() : Retrofit? {
            if (duplicateRetrofit == null) {
                duplicateRetrofit = Retrofit.Builder()
                    .baseUrl(DUPLICATE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return duplicateRetrofit
        }
    }
}