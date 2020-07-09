package com.udayasreetechnologies.sdklibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class SignInActivity : AppCompatActivity() {

    private lateinit var imageView : ImageView

    private lateinit var arrowLogin : FrameLayout
    private lateinit var arrowRegister : FrameLayout

    private lateinit var loginAction : USTextView
    private lateinit var registerAction : USTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initView()
    }

    private fun initView() {
        imageView = findViewById(R.id.signin_image_id)

        arrowLogin = findViewById(R.id.signin_login_arrow_id)
        arrowRegister = findViewById(R.id.signin_register_arrow_id)

        loginAction = findViewById(R.id.signin_login_action)
        registerAction = findViewById(R.id.signin_register_action)

        arrowLogin.layoutParams.height = (AppUtility.SCREEN_WIDTH * 0.10).toInt()
        arrowRegister.layoutParams.height = (AppUtility.SCREEN_WIDTH * 0.10).toInt()
    }

    private fun launchFragment(fragment : Fragment?) {
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
}
