package com.androidnavigation.main

import android.app.FragmentManager
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.androidnavigation.R
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

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, NewsFragment())
                .commit()

        val header = navView.getHeaderView(0)
        header.profileButton.setOnClickListener({})
        header.shareButton.setOnClickListener({})
    }

    fun setupDrawerContent() {
        navView.setCheckedItem(0)
        navView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.nav_news -> {
                fragmentManager!!
                        .popBackStackImmediate(NewsFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            R.id.nav_messages -> {
                fragmentManager!!
                        .popBackStackImmediate(MessagesFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            R.id.nav_friends -> {
                fragmentManager!!
                        .popBackStackImmediate(FriendsFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            R.id.nav_notification -> {
                fragmentManager!!
                        .popBackStackImmediate(NotificationsFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            R.id.nav_groups -> {
                fragmentManager!!
                        .popBackStackImmediate(GroupsFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            R.id.nav_settings -> {
                fragmentManager!!
                        .popBackStackImmediate(SettingsFragment().id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
        menuItem.isChecked = true
        title = menuItem.title
        drawerLayout.closeDrawers()
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
