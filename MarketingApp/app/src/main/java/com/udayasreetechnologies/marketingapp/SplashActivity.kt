package com.udayasreetechnologies.marketingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udayasreetechnologies.sdklibrary.HomeActivity
import com.udayasreetechnologies.sdklibrary.utils.SharedPreferenceUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shplash)

        val preferenceUtils = SharedPreferenceUtils(this)
        val packageName = applicationContext.packageName
        val appVersion = packageManager.getPackageInfo(packageName, 0).versionName
        preferenceUtils.setPackageName(packageName)
        preferenceUtils.setPackageVersion(appVersion)

        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("PREFERENCE_NAME", "USS_APP")
        intent.putExtra("PACKAGE_NAME", packageName)
        intent.putExtra("PACKAGE_VERSION", appVersion)
        startActivity(intent)
    }
}
