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

class RegisterFragment : Fragment(), View.OnClickListener {

    private var mContext : Context? = null
    private lateinit var listener : OnRegisterFragmentCallBack

    private lateinit var firstNameET : USEditText
    private lateinit var lastNameET : USEditText
    private lateinit var mobileET : USEditText
    private lateinit var emailIdET : USEditText
    private lateinit var passwordET : USEditText
    private lateinit var retryPasswordET : USEditText
    private lateinit var address1ET : USEditText
    private lateinit var address2ET : USEditText
    private lateinit var landMarkET : USEditText
    private lateinit var countryET : USEditText
    private lateinit var stateET : USEditText
    private lateinit var cityET : USEditText
    private lateinit var postalCodeET : USEditText

    private lateinit var loginAction : USTextView
    private lateinit var registerAction : USButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mContext = context
            listener = context as OnRegisterFragmentCallBack
        } catch (e: Exception) {
            throw RuntimeException("$context must implement RegisterFragment")
        }
    }

    companion object {
        fun newInstance(): RegisterFragment {
            val fragment = RegisterFragment()

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
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        if (mContext != null) {
            initView(view)
        } else {
            listener.onContextFailed()
        }
        return view
    }


    private fun initView(view: View) {
        firstNameET = view.findViewById(R.id.frag_reg_fname_id)
        lastNameET = view.findViewById(R.id.frag_reg_lname_id)
        mobileET = view.findViewById(R.id.frag_reg_mobile_id)
        emailIdET = view.findViewById(R.id.frag_reg_email_id)
        passwordET = view.findViewById(R.id.frag_reg_password_id)
        retryPasswordET = view.findViewById(R.id.frag_reg_retype_password_id)

        address1ET = view.findViewById(R.id.frag_reg_address1_id)
        address2ET = view.findViewById(R.id.frag_reg_address2_id)

        landMarkET = view.findViewById(R.id.frag_reg_landmark_id)
        countryET = view.findViewById(R.id.frag_reg_country_id)
        stateET = view.findViewById(R.id.frag_reg_state_id)
        cityET = view.findViewById(R.id.frag_reg_city_id)
        postalCodeET = view.findViewById(R.id.frag_reg_postalcode_id)

        loginAction = view.findViewById(R.id.frag_reg_login_action)
        registerAction = view.findViewById(R.id.frag_reg_register_action)

        loginAction.setOnClickListener(this)
        registerAction.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.frag_reg_login_action -> {
                listener.onAlreadyHaveAccountListener()
            }

            R.id.frag_reg_register_action -> {

            }
        }
    }

    interface OnRegisterFragmentCallBack {
        fun onContextFailed()
        fun onAlreadyHaveAccountListener()
    }
}
