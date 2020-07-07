package com.udayasreetechnologies.sdklibrary.retrofitpkg.callbacks

import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.HomeMainModel

interface OnHomeApiListener {
    fun onResponseFailed(error : String)
    fun onHomeApiSuccessful(homeMainModel : HomeMainModel)
}