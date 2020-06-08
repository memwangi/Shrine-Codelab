package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.password_edit_text

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)

        // Set an error if the password is less than 8 characters
        view.next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.shr_error_password)
            } else {
                // clear the error
                password_text_input.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        // clear the error once more than 8 characters are typed
        view.password_edit_text.doOnTextChanged { text, start, count, after ->
            if(isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = null
            }
        }

        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        val valid = text != null && text.length >= 8
        return valid
    }
}
