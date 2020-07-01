package com.udayasreetechnologies.marketingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udayasreetechnologies.sdklibrary.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shplash)

        startActivity(Intent(this, HomeActivity::class.java))
    }
}
