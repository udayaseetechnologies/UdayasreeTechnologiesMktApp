package com.udayasreetechnologies.sdklibrary.utils

import android.content.Context
import android.content.SharedPreferences
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility

class SharedPreferenceUtils(private val mContext: Context) {
    private var mSharedPreferences: SharedPreferences = mContext.getSharedPreferences(AppUtility.PREFERENCE_NAME, Context.MODE_PRIVATE)

    private val FIRST_TIME_LAUNCH = "first_time_launch"
    private val ONE_TIME_LOGIN = "one_time_login"
    private val APP_PACKAGE_NAME = "app_package_name"
    private val APP_PACKAGE_VERSION = "app_package_version"

    public fun setFirstTimeLaunch(isLaunched : Boolean) {
        mSharedPreferences.edit().putBoolean(FIRST_TIME_LAUNCH, isLaunched).apply()
    }

    public fun getFirstTimeLaunch() : Boolean {
        return mSharedPreferences.getBoolean(FIRST_TIME_LAUNCH, false)
    }

    public fun setOneTimeLogin(isLogin: Boolean) {
        mSharedPreferences.edit().putBoolean(ONE_TIME_LOGIN, isLogin).apply()
    }

    public fun getOneTimeLogin() : Boolean {
        return mSharedPreferences.getBoolean(ONE_TIME_LOGIN, false)
    }

    public fun setPackageName(appPackageID : String) {
        mSharedPreferences.edit().putString(APP_PACKAGE_NAME, appPackageID).apply()
    }

    public fun getPackageName() : String? {
        return mSharedPreferences.getString(APP_PACKAGE_NAME, "")
    }

    public fun setPackageVersion(appPackageVersion : String) {
        mSharedPreferences.edit().putString(APP_PACKAGE_VERSION, appPackageVersion).apply()
    }

    public fun getPackageVersion() : String? {
        return mSharedPreferences.getString(APP_PACKAGE_VERSION, "")
    }




    public fun clear() {
        mSharedPreferences.edit().clear().apply()
    }
}