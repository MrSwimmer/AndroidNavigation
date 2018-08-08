package com.androidnavigation.auth.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidnavigation.R
import kotlinx.android.synthetic.main.fragment_intro.view.*


class IntroFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_intro, container, false)
        view.helloButton.setOnClickListener({
            fragmentManager!!
                    .beginTransaction()
                    .replace(R.id.container, SignInFragment())
                    .commit()
        })
        return view
    }
}