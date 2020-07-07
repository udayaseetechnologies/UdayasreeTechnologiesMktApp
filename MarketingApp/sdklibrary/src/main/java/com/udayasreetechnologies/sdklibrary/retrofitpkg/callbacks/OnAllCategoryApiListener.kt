package com.udayasreetechnologies.sdklibrary.retrofitpkg.callbacks

import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.AllCategoryModel

interface OnAllCategoryApiListener {
    fun onResponseFailed(error : String)
    fun onAllCategoryApiSuccessful(allCategoryList : List<AllCategoryModel>)
}