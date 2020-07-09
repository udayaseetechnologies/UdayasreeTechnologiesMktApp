package com.udayasreetechnologies.sdklibrary.retrofitpkg.callbacks

import com.udayasreetechnologies.sdklibrary.retrofitpkg.models.PostalMainModel

interface OnPostalQueryApiListener {

    fun onResponseFailed(error : String)
    fun onPostalQueryApiSuccessful(homeMainModel : PostalMainModel)
}