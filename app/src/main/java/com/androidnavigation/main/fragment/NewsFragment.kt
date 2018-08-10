package com.androidnavigation.main.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidnavigation.R
import com.androidnavigation.auth.fragment.SignUpFragment
import kotlinx.android.synthetic.main.fragment_news.view.*


class NewsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        view.postButton.setOnClickListener({
            val bundle = Bundle()
            bundle.putString("id", "1")
            val postFragment = PostFragment()
            postFragment.arguments = bundle
            fragmentManager!!
                    .beginTransaction()
                    .replace(R.id.container, postFragment)
                    .addToBackStack(null)
                    .commit()
        })
        return view
    }
}