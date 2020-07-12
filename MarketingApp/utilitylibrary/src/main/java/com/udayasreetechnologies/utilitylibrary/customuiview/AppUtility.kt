package com.udayasreetechnologies.utilitylibrary.customuiview

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

class AppUtility {
    companion object {
        var SCREEN_WIDTH = 0
        var SCREEN_HEIGHT = 0

        var PREFERENCE_NAME = "USS_Default"
        var PACKAGE_NAME = ""
        var PACKAGE_VERSION = ""

        fun networkConnectivity(context: Context): Boolean {
            val connectivityManager: ConnectivityManager? =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                if (networkInfo != null && networkInfo.isConnected) {
                    return true
                }
            }
            Toast.makeText(context, "Required Internet Connection", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}