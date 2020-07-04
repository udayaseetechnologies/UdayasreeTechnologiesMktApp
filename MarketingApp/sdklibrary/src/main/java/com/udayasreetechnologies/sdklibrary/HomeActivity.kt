package com.udayasreetechnologies.sdklibrary

import android.Manifest
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.udayasreetechnologies.sdklibrary.ui.productlist.ProductListFragment
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.searchview.MaterialSearchView
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    ProductListFragment.OnHomeFragmentListener {

    private lateinit var permissions: Array<String>
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var searchView : MaterialSearchView

    private lateinit var cartBadge : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.home_toolbar)
        setSupportActionBar(toolbar)
        initScreenSize()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkRunTimePermissions()
        } else {
            initView()
        }
    }

    private fun initScreenSize() {
        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        AppUtility.SCREEN_WIDTH = point.x
        AppUtility.SCREEN_HEIGHT = point.y
    }

    private fun initView() {
        drawerLayout = findViewById(R.id.home_drawer_layout)
        navView = findViewById(R.id.home_nav_view)
        searchView = findViewById(R.id.home_searchview)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        productListFragment()
    }

    private fun productListFragment() {
        launchFragment(ProductListFragment.newInstance(), "Products")
    }

/*-------------------------- Listener's ------------------------*/
    override fun onContextFailedListener() {
        productListFragment()
    }

    override fun onAddToCartUpdateListener() {

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
            R.id.drawer_home_id -> {

            }
            R.id.drawer_settings_id -> {

            }
            R.id.drawer_account_id -> {

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        val cartMenu = menu?.findItem(R.id.menu_home_cart)?.actionView
        cartBadge = cartMenu?.findViewById(R.id.menu_home_cart_badge)!!
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.groupId) {
            R.id.menu_home_cart ->{
            }

            else -> {
                return false
            }
        }
        return true
    }

    override fun onBackPressed() {
        if (searchView.isSearchOpen){
            searchView.closeSearch()
        } else {
            super.onBackPressed()
        }
    }
}