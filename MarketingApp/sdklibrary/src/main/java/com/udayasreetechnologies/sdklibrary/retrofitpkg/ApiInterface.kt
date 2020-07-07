package com.udayasreetechnologies.sdklibrary.retrofitpkg

import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.AllCategoryModel
import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.HomeMainModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("/demowebsite/customrest/jsonapidetails/getHomejson")
    fun getHomeMainApi(
        @Field("consumerKey") consumerKey: String,
        @Field("consumerSecret") consumerSecret: String,
        @Field("leveltype") leveltype: String,
        @Field("packageId") packageId: String,
        @Field("appVersion") appVersion: String
    ): Call<HomeMainModel>

    @FormUrlEncoded
    @POST("/demowebsite/customrest/jsonapidetails/getcategoryAll")
    fun getAllCategoryApi(
        @Field("consumerKey") consumerKey: String,
        @Field("consumerSecret") consumerSecret: String,
        @Field("leveltype") leveltype: String,
        @Field("packageId") packageId: String,
        @Field("appVersion") appVersion: String,
        @Field("parentId") parentId: String
    ): Call<List<AllCategoryModel>>

}