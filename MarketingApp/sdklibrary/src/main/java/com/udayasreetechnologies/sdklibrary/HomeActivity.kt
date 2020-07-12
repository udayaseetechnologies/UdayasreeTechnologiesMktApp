package com.udayasreetechnologies.sdklibrary

import android.Manifest
import android.content.Intent
import android.graphics.Point
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.udayasreetechnologies.sdklibrary.ui.productlist.ProductListFragment
import com.udayasreetechnologies.sdklibrary.utils.AppConstants
import com.udayasreetechnologies.sdklibrary.utils.CountDrawable
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.searchview.MaterialSearchView


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    ProductListFragment.OnHomeFragmentListener {

    private var mFragmentPosition : Int = 0
    private lateinit var permissions: Array<String>
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ThemeColors(this)
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.home_toolbar)
        setSupportActionBar(toolbar)
        initScreenSize()

        if (bundleData()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                checkRunTimePermissions()
            } else {
                initView()
            }
        } else {
            AlertDialog.Builder(this, android.R.style.Theme_Dialog)
                .setPositiveButton(R.string.exit){dialog, _ ->
                    dialog.dismiss()
                    finishAffinity()
                }
                .setTitle(R.string.failed)
                .setMessage(R.string.error_data_missing)
                .create().show()
        }
    }

    private fun bundleData() : Boolean {
        val bundle = intent.extras
        if (bundle?.containsKey("PREFERENCE_NAME")!! && bundle.containsKey("PACKAGE_NAME")
            && bundle.containsKey("PACKAGE_VERSION")) {
            AppUtility.PREFERENCE_NAME = intent.extras?.getString("PREFERENCE_NAME")!!
            AppUtility.PACKAGE_NAME = intent.extras?.getString("PACKAGE_NAME")!!
            AppUtility.PACKAGE_VERSION = intent.extras?.getString("PACKAGE_VERSION")!!
            return true
        }
        return false
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
        menuItem  = menu?.findItem(R.id.menu_home_cart)
        cartBadge("18")
        return super.onCreateOptionsMenu(menu)
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

    private fun cartBadge(count : String) {
        if (menuItem != null) {
            val icon = menuItem?.icon as LayerDrawable
            val reuse = icon.findDrawableByLayerId(R.id.menu_home_cart_badge)
            val cartBadge = if (reuse != null && reuse is CountDrawable) {
                reuse
            } else {
                CountDrawable(this)
            }
            cartBadge.setCount(count)
            icon.mutate()
            icon.setDrawableByLayerId(R.id.menu_home_cart_badge, cartBadge)
        }
    }

    private fun onBackPressedAction(): Boolean {
        when(mFragmentPosition) {
            0 -> {

            }
            else -> {
                return true
            }
        }
        return false
    }

    override fun onBackPressed() {
        if (onBackPressedAction()) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            clearBackStack()
            startActivity(intent)
            finishAffinity()
            super.onBackPressed()
        }
    }

    override fun onResume() {
        /*Handler().postDelayed({
            ThemeColors.setNewThemeColor(this@HomeActivity, red, green, blue)
        }, 1000)*/
        super.onResume()
    }
}