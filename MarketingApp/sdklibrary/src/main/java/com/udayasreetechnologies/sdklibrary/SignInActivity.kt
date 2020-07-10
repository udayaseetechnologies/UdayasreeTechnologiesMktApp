package com.udayasreetechnologies.sdklibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.udayasreetechnologies.sdklibrary.ui.signin.LoginFragment
import com.udayasreetechnologies.sdklibrary.ui.signin.RegisterFragment
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

class SignInActivity : AppCompatActivity(), View.OnClickListener, LoginFragment.OnLoginFragmentCallBack,
    RegisterFragment.OnRegisterFragmentCallBack {

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

        loginAction.setOnClickListener(this)
        registerAction.setOnClickListener(this)

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
            Handler().postDelayed({
                if (isLogin) {
                    arrowLogin.visibility = View.VISIBLE
                    arrowRegister.visibility = View.INVISIBLE

                    loginAction.background = ContextCompat.getDrawable(this, R.drawable.rect_login)
                    registerAction.setBackgroundColor(ContextCompat.getColor(this, R.color.color_white))

                    loginAction.setTextColor(ContextCompat.getColor(this, R.color.color_white))
                    registerAction.setTextColor(ContextCompat.getColor(this, R.color.color_gray))
                } else {
                    arrowRegister.visibility = View.VISIBLE
                    arrowLogin.visibility = View.INVISIBLE

                    registerAction.background = ContextCompat.getDrawable(this, R.drawable.rect_login)
                    loginAction.setBackgroundColor(ContextCompat.getColor(this, R.color.color_white))

                    loginAction.setTextColor(ContextCompat.getColor(this, R.color.color_gray))
                    registerAction.setTextColor(ContextCompat.getColor(this, R.color.color_white))
                }
            }, 200)
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

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.signin_login_action -> {
                launchFragment(LoginFragment.newInstance(), true)
            }
            R.id.signin_register_action -> {
                launchFragment(RegisterFragment.newInstance(), false)
            }
        }
    }

    override fun onNewRegistrationListener() {
        launchFragment(RegisterFragment.newInstance(), false)
    }

    override fun onAlreadyHaveAccountListener() {
        launchFragment(LoginFragment.newInstance(), true)
    }

    override fun onContextFailed() {
        launchFragment(LoginFragment.newInstance(), true)
    }
}
