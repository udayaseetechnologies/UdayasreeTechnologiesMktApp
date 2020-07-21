package com.udayasreetechnologies.sdklibrary.retrofitpkg

import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.AllCategoryModel
import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.HomeMainModel
import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.PostalMainModel
import com.udayasreetechnologies.sdklibrary.ui.productlist.models.MainHomeModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @Headers("secret-key: \$2b\$10\$YPdEAv88EmvermFjqYZ8xuzFrumQIQf4stIX2I1WgSMKGv1DKESSe")
    @GET("/b/5f166c04c58dc34bf5d79760")
    fun getDuplicateHomeProductApi() : Call<List<MainHomeModel>>
/*------------------------------------------------------------------------*/

    @GET
    fun getPostalDetailApi(@Url url : String) : Call<PostalMainModel>

    @FormUrlEncoded
    @POST("/demowebsite/customrest/jsonapidetails/getHomejson")
    fun getHomeMainApi(
        @Field("consumerKey") consumerKey: String,
        @Field("consumerSecret") consumerSecret: String,
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

    @FormUrlEncoded
    @POST("/demowebsite/customrest/jsonapidetails/getproductbycategory")
    fun getProductListByCategory(
        @Field("consumerKey") consumerKey : String,
        @Field("consumerSecret") consumerSecret : String,
        @Field("packageId") packageId : String,
        @Field("appVersion") appVersion : String,
        @Field("categoryId") categoryId : String
    )

    @FormUrlEncoded
    @POST("/demowebsite/customrest/jsonapidetails/getproductdetail")
    fun getProductDetail(
        @Field("consumerKey") consumerKey : String,
        @Field("consumerSecret") consumerSecret : String,
        @Field("packageId") packageId : String,
        @Field("appVersion") appVersion : String,
        @Field("productId") productId : String
    )

    @FormUrlEncoded
    @POST("/demowebsite/customrest/staticorder/setUserBillingAddress")
    fun userRegistrationOrUpdate(
        @Field("consumerKey") consumerKey : String,
        @Field("consumerSecret") consumerSecret : String,
        @Field("packageId") packageId : String,
        @Field("appVersion") appVersion : String,
        @Field("fName") firstName : String,
        @Field("lName") lastName : String,
        @Field("mobileno") mobile : String,
        @Field("emailId") emailId : String,
        @Field("password") password : String,
        @Field("street0") address1 : String,
        @Field("street1") address2 : String,
        @Field("landmark") landmark : String,
        @Field("country") country : String,
        @Field("region") state : String,
        @Field("city") city : String,
        @Field("addressType") addressType : String,
        @Field("postcode") postalCode : String,
        @Field("reqType") reqType : String
    )


    /*
    1. http://68.183.82.193/demowebsite/customrest/jsonapidetails/getHomejson
(consumerKey,consumerSecret,packageId,appVersion)

2. http://68.183.82.193/demowebsite/customrest/staticorder/setUserBillingAddress
(emailId,consumerKey,consumerSecret,,packageId,appVersion,fName,lName,street0,street1,postcode,addressType,
landmark,country,region,city,password,reqType=>SIGN_UP)

3. http://68.183.82.193/demowebsite/customrest/jsonapidetails/getcategoryAll
(consumerKey,consumerSecret,,packageId,appVersion,parentId,leveltype)

4. http://68.183.82.193/demowebsite/customrest/jsonapidetails/getproductbycategory
(consumerKey,consumerSecret,,packageId,appVersion,categoryId)

5. http://68.183.82.193/demowebsite/customrest/jsonapidetails/getproductdetail
(consumerKey,consumerSecret,,packageId,appVersion,productId)
     */
}