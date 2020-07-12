package com.udayasreetechnologies.sdklibrary.ui.signin


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

class RegisterFragment : Fragment(), View.OnClickListener {

    private var mContext: Context? = null
    private lateinit var listener: OnRegisterFragmentCallBack

    private lateinit var firstNameET: USEditText
    private lateinit var lastNameET: USEditText
    private lateinit var mobileET: USEditText
    private lateinit var emailIdET: USEditText
    private lateinit var passwordET: USEditText
    private lateinit var retypePasswordET: USEditText
    private lateinit var address1ET: USEditText
    private lateinit var address2ET: USEditText
    private lateinit var landMarkET: USEditText
    private lateinit var countryET: USEditText
    private lateinit var stateET: USEditText
    private lateinit var cityET: USEditText
    private lateinit var postalCodeET: USEditText

    private lateinit var radioGroup : RadioGroup

    private lateinit var loginAction: USTextView
    private lateinit var registerAction: USButton

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
        retypePasswordET = view.findViewById(R.id.frag_reg_retype_password_id)

        address1ET = view.findViewById(R.id.frag_reg_address1_id)
        address2ET = view.findViewById(R.id.frag_reg_address2_id)

        landMarkET = view.findViewById(R.id.frag_reg_landmark_id)
        countryET = view.findViewById(R.id.frag_reg_country_id)
        stateET = view.findViewById(R.id.frag_reg_state_id)
        cityET = view.findViewById(R.id.frag_reg_city_id)
        postalCodeET = view.findViewById(R.id.frag_reg_postalcode_id)

        radioGroup = view.findViewById(R.id.frag_reg_radio_group_id)

        loginAction = view.findViewById(R.id.frag_reg_login_action)
        registerAction = view.findViewById(R.id.frag_reg_register_action)

        loginAction.setOnClickListener(this)
        registerAction.setOnClickListener(this)
    }

    private fun userRegistration() {
        if (AppUtility.networkConnectivity(mContext!!)) {
            val firstName = firstNameET.text.toString()
            val lastName = lastNameET.text.toString()
            val mobile = mobileET.text.toString()

            val email = emailIdET.text.toString()
            val password = passwordET.text.toString()
            val retypePassword = retypePasswordET.text.toString()

            val address1 = address1ET.text.toString()
            val address2 = address2ET.text.toString()
            val landMark = landMarkET.text.toString()
            val country = countryET.text.toString()
            val state = stateET.text.toString()
            val city = cityET.text.toString()
            val postalCode = postalCodeET.text.toString()

            val addressType = when(radioGroup.checkedRadioButtonId){
                R.id.frag_reg_rb_home_id ->{ "Home" }
                R.id.frag_reg_rb_work_id -> { "Work" }
                else -> { "" }
            }

            val isEmailValid = isEmailValid(email)

            val isPasswordMatch =
                password.length >= 8 && retypePassword.length >= 8 && password == retypePassword

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && mobile.length == 10 && isEmailValid && isPasswordMatch
                && address1.isNotEmpty() && landMark.isNotEmpty() && country.isNotEmpty()
                && state.isNotEmpty() && city.isNotEmpty()  && postalCode.length == 6 && addressType.isNotEmpty()
            ) {

                listener.onUserRegisterApiListener(
                    DetailModel(
                        firstName, lastName, mobile, email, password, address1, address2,
                        landMark, country, state, city, postalCode, addressType
                    )
                )

            } else {

                if (firstName.isEmpty()) {
                    firstNameET.error = getString(R.string.error_name)
                }

                if (lastName.isEmpty()) {
                    lastNameET.error = getString(R.string.error_name)
                }

                if (mobile.length < 10) {
                    mobileET.error = getString(R.string.error_contact)
                }

                if (!isEmailValid) {
                    emailIdET.error = getString(R.string.error_email)
                }

                if (!isPasswordMatch) {
                    passwordET.setText("")
                    retypePasswordET.setText("")
                    passwordET.error = getString(R.string.error_password)
                }

                if (address1.isEmpty()) {
                    address1ET.error = getString(R.string.error_address)
                }

                if (landMark.isEmpty()) {
                    landMarkET.error = getString(R.string.error_landmark)
                }

                if (country.isEmpty()) {
                    countryET.error = getString(R.string.error_country)
                }

                if (state.isEmpty()) {
                    stateET.error = getString(R.string.error_state)
                }

                if (city.isEmpty()) {
                    cityET.error = getString(R.string.error_city)
                }

                if (postalCode.length < 6) {
                    postalCodeET.error = getString(R.string.error_postalcode)
                }

                if (addressType.isEmpty()) {
                    Toast.makeText(mContext, R.string.error_address_type, Toast.LENGTH_SHORT).show()
                }
            }
        }
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
        when (view?.id) {
            R.id.frag_reg_login_action -> {
                listener.onAlreadyHaveAccountListener()
            }

            R.id.frag_reg_register_action -> {
                userRegistration()
            }
        }
    }

    interface OnRegisterFragmentCallBack {
        fun onContextFailed()
        fun onAlreadyHaveAccountListener()
        fun onUserRegisterApiListener(detailModel: DetailModel)
    }
}
