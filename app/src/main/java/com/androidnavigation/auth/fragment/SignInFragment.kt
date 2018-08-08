package com.androidnavigation.auth.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidnavigation.R
import com.androidnavigation.main.MainActivity
import kotlinx.android.synthetic.main.fragment_sign_in.view.*


class SignInFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        view.gotoRegButton.setOnClickListener({
            fragmentManager!!
                    .beginTransaction()
                    .replace(R.id.container, SignUpFragment())
                    .addToBackStack(null)
                    .commit()
        })
        view.signInButton.setOnClickListener({
            startActivity(Intent(activity, MainActivity::class.java))
            activity!!.finish()
        })
        return view
    }
}