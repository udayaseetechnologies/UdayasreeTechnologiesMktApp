package com.udayasreetechnologies.sdklibrary.ui.signin


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.sdklibrary.ui.signin.models.DetailModel
import com.udayasreetechnologies.utilitylibrary.customuiview.AppUtility
import com.udayasreetechnologies.utilitylibrary.customuiview.USButton
import com.udayasreetechnologies.utilitylibrary.customuiview.USEditText
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView
import java.util.regex.Matcher
import java.util.regex.Pattern

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment(), View.OnClickListener {

    private var mContext : Context? = null
    private lateinit var listener : OnLoginFragmentCallBack

    private lateinit var skipAction : USTextView
    private lateinit var emailIdET : USEditText
    private lateinit var passwordET : USEditText
    private lateinit var resetPasswordAction : USTextView
    private lateinit var registerAction : USTextView
    private lateinit var loginAction : USButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mContext = context
            listener = context as OnLoginFragmentCallBack
        } catch (e: Exception) {
            throw RuntimeException("$context must implement LoginFragment")
        }
    }

    companion object {
        fun newInstance() = LoginFragment().apply {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*val bundle = arguments
        if (bundle != null && bundle.containsKey(ARG_TEAMNAME_LIST)) {
            teamNameList.clear()
            bundle.getStringArrayList(ARG_TEAMNAME_LIST)?.let { teamNameList.addAll(it) }
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        if (mContext != null) {
            initView(view)
        } else {
            listener.onContextFailed()
        }
        return view
    }

    private fun initView(view: View) {
        emailIdET = view.findViewById(R.id.frag_login_email_id)
        passwordET = view.findViewById(R.id.frag_login_password_id)

        skipAction = view.findViewById(R.id.frag_login_skip_action)
        resetPasswordAction = view.findViewById(R.id.frag_login_reset_action)
        registerAction = view.findViewById(R.id.frag_login_register_action)
        loginAction = view.findViewById(R.id.frag_login_login_action)

        skipAction.setOnClickListener(this)
        resetPasswordAction.setOnClickListener(this)
        registerAction.setOnClickListener(this)
        loginAction.setOnClickListener(this)

        loginAction.layoutParams.width = (AppUtility.SCREEN_WIDTH * 0.6).toInt()
    }

    private fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val inputStr: CharSequence = email
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            return true
        }
        return false
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.frag_login_skip_action -> {
                listener.onSkipActionListener()
            }

            R.id.frag_login_reset_action -> {

            }

            R.id.frag_login_register_action -> {
                listener.onNewRegistrationListener()
            }

            R.id.frag_login_login_action -> {
                val email = emailIdET.text.toString()
                val password = passwordET.text.toString()
                val isEmailValid = isEmailValid(email)

                if (isEmailValid && password.length >= 8) {
                    listener.onUserLoginApiListener(DetailModel(email, password))
                } else {
                    if (!isEmailValid) {
                        emailIdET.error = getString(R.string.error_email)
                    }
                    if (password.length < 8) {
                        passwordET.setText("")
                        passwordET.error = getString(R.string.error_password)
                    }
                }
            }
        }
    }

    interface OnLoginFragmentCallBack {
        fun onContextFailed()
        fun onNewRegistrationListener()
        fun onSkipActionListener()
        fun onUserLoginApiListener(detailModel: DetailModel)
    }
}
