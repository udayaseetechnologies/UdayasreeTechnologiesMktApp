package com.udayasreetechnologies.sdklibrary

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var permissions: Array<String>
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar = findViewById(R.id.home_toolbar)
        setSupportActionBar(toolbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkRunTimePermissions()
        } else {
            initView()
        }
    }

    private fun initView() {
        drawerLayout = findViewById(R.id.home_drawer_layout)
        navView = findViewById(R.id.home_nav_view)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        homeFragment()
    }

    private fun launchFragment(fragment : Fragment?, title : String) {
        if (fragment != null) {
            supportActionBar?.title = title
            clearBackStack()
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fragment_slide_left_enter,
                    R.anim.fragment_slide_left_exit,
                    R.anim.fragment_slide_right_enter,
                    R.anim.fragment_slide_right_exit
                )
                .replace(R.id.home_fragment_container, fragment)
                .commit()
        }
    }

    private fun clearBackStack() {
        try {
            val fragments: Int = supportFragmentManager.backStackEntryCount
            for (i in fragments downTo 1) {
                supportFragmentManager.popBackStackImmediate()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun homeFragment() {

    }

    private fun checkRunTimePermissions() {
        permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val permissionNeeded = ArrayList<String>()

        if (permissionNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(this,
                permissionNeeded.toArray(arrayOfNulls<String>(permissionNeeded.size)),
                AppConstants.MULTIPLE_PERMISSION
            )
        } else {
            initView()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == AppConstants.MULTIPLE_PERMISSION && permissions.isNotEmpty()) {
            initView()
        } else {
            checkRunTimePermissions()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.groupId) {
            R.id.nav_id1 -> {

            }
            R.id.nav_id2 -> {

            }
            R.id.nav_id3 -> {

            }
            R.id.nav_id4 -> {

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}