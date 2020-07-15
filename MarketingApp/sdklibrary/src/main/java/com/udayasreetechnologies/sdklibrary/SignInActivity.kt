package com.udayasreetechnologies.sdklibrary

import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.udayasreetechnologies.sdklibrary.ui.signin.LoginFragment
import com.udayasreetechnologies.sdklibrary.ui.signin.RegisterFragment
import com.udayasreetechnologies.sdklibrary.ui.signin.models.DetailModel
import com.udayasreetechnologies.sdklibrary.utils.SharedPreferenceUtils
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class SignInActivity : AppCompatActivity(), LoginFragment.OnLoginFragmentCallBack, RegisterFragment.OnRegisterFragmentCallBack {

    private var mFragmentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initScreenSize()
        loginFragment()
    }

    private fun initScreenSize() {
        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        AppUtility.SCREEN_WIDTH = point.x
        AppUtility.SCREEN_HEIGHT = point.y
    }

    private fun loginFragment() {
        mFragmentCount = 0
        launchFragment(LoginFragment.newInstance(), true)
    }

    private fun launchFragment(fragment : Fragment?, isLogin : Boolean) {
        if (fragment != null) {
            clearBackStack()
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fragment_slide_left_enter,
                    R.anim.fragment_slide_left_exit,
                    R.anim.fragment_slide_right_enter,
                    R.anim.fragment_slide_right_exit
                )
                .replace(R.id.signin_fragment_container, fragment)
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

    override fun onNewRegistrationListener() {
        mFragmentCount = 1
        launchFragment(RegisterFragment.newInstance(), false)
    }

    override fun onAlreadyHaveAccountListener() {
        loginFragment()
    }

    override fun onSkipActionListener() {
        SharedPreferenceUtils(this).setFirstTimeLaunch(true)

        val bundle = intent.extras
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("PREFERENCE_NAME", bundle?.getString("PREFERENCE_NAME")!!)
        intent.putExtra("PACKAGE_NAME", bundle?.getString("PACKAGE_NAME")!!)
        intent.putExtra("PACKAGE_VERSION", bundle?.getString("PACKAGE_VERSION")!!)
        startActivity(intent)
    }

    override fun onUserLoginApiListener(detailModel: DetailModel) {

    }

    override fun onUserRegisterApiListener(detailModel: DetailModel) {

    }

    override fun onContextFailed() {
        loginFragment()
    }

    override fun onBackPressed() {
        if (mFragmentCount == 1) {
            loginFragment()
        } else {
            finishAffinity()
            super.onBackPressed()
        }
    }
}
