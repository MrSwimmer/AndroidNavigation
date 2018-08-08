package com.androidnavigation.main.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidnavigation.R


class MessagesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)
        return view
    }
}