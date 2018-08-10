package com.androidnavigation.main

import android.app.Fragment
import android.app.FragmentManager
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.androidnavigation.R
import com.androidnavigation.auth.fragment.SignInFragment
import com.androidnavigation.main.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.view.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDrawerContent()
        setSupportActionBar(toolbar)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)

        fragmentManager
                .beginTransaction()
                .replace(R.id.container, NewsFragment())
                .commit()

        val header = navView.getHeaderView(0)
        header.profileButton.setOnClickListener({
            fragmentManager!!
                    .popBackStackImmediate(ProfileFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        })
        header.shareButton.setOnClickListener({})
    }

    private fun setupDrawerContent() {
        navView.setCheckedItem(0)
        Log.i("code", "00")
        navView.setNavigationItemSelectedListener { menuItem ->
            Log.i("code", fragmentManager.backStackEntryCount.toString())
            for (i in 0 until fragmentManager.backStackEntryCount) {
                fragmentManager.popBackStackImmediate()
            }
            val fragment: Fragment
            when (menuItem.itemId) {
                R.id.nav_news -> fragment = NewsFragment()
                R.id.nav_messages -> fragment = MessagesFragment()
                R.id.nav_friends -> fragment = FriendsFragment()
                R.id.nav_notification -> fragment = NotificationsFragment()
                R.id.nav_groups -> fragment = GroupsFragment()
                R.id.nav_settings -> fragment = SettingsFragment()
                else -> fragment = NewsFragment()
            }
            fragmentManager!!
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            menuItem.isChecked = true
            title = menuItem.title
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }
}
