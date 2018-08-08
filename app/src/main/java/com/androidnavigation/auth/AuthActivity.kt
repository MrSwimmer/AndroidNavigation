package com.androidnavigation.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidnavigation.R
import com.androidnavigation.auth.fragment.IntroFragment
import com.androidnavigation.auth.fragment.SignInFragment
import com.androidnavigation.main.MainActivity
import kotlinx.android.synthetic.main.fragment_sign_in.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        if (isSignedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, IntroFragment())
                    .commit()
        }
    }

    fun isSignedIn(): Boolean {
        return true
    }
}