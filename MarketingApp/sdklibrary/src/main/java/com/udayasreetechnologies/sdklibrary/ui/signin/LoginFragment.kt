package com.udayasreetechnologies.sdklibrary.ui.signin


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udayasreetechnologies.sdklibrary.R
import com.udayasreetechnologies.utilitylibrary.customuiview.USButton
import com.udayasreetechnologies.utilitylibrary.customuiview.USEditText
import com.udayasreetechnologies.utilitylibrary.customuiview.USTextView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment(), View.OnClickListener {

    private var mContext : Context? = null
    private lateinit var listener : OnLoginFragmentCallBack

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
        fun newInstance(): LoginFragment {
            val fragment = LoginFragment()

            return fragment
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

        resetPasswordAction = view.findViewById(R.id.frag_login_reset_action)
        registerAction = view.findViewById(R.id.frag_login_register_action)
        loginAction = view.findViewById(R.id.frag_login_login_action)

        resetPasswordAction.setOnClickListener(this)
        registerAction.setOnClickListener(this)
        loginAction.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.frag_login_reset_action -> {

            }

            R.id.frag_login_register_action -> {
                listener.onNewRegistrationListener()
            }

            R.id.frag_login_login_action -> {

            }
        }
    }

    interface OnLoginFragmentCallBack {
        fun onContextFailed()
        fun onNewRegistrationListener()
    }
}
