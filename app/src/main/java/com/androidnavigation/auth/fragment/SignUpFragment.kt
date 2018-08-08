package com.androidnavigation.auth.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidnavigation.R
import com.androidnavigation.main.MainActivity
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        view.backButton.setOnClickListener({
            fragmentManager!!
                    .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        })
        view.signUpButton.setOnClickListener({
            startActivity(Intent(activity, MainActivity::class.java))
            activity!!.finish()
        })
        return view
    }
}