package com.shahabtariq.i230507

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var tabIcons: List<ImageView>
    private lateinit var indicators: List<View>
    private lateinit var headerTitle: TextView
    private val titles = listOf("kinnect", "Friends", "Marketplace", "Notifications", "Menu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headerTitle = findViewById(R.id.tvHeaderTitle)
        tabIcons = listOf(
            findViewById(R.id.tabHome),
            findViewById(R.id.tabFriends),
            findViewById(R.id.tabMarket),
            findViewById(R.id.tabNotifications),
            findViewById(R.id.tabMenu)
        )
        indicators = listOf(
            findViewById(R.id.indHome),
            findViewById(R.id.indFriends),
            findViewById(R.id.indMarket),
            findViewById(R.id.indNotifications),
            findViewById(R.id.indMenu)
        )

        if (savedInstanceState == null) {
            showTab(HomeFeedFragment())
        } else {
            highlight(indexOf(supportFragmentManager.findFragmentById(R.id.fragmentContainer)))
        }

        findViewById<ImageView>(R.id.btnSearch).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
        findViewById<ImageView>(R.id.btnMessenger).setOnClickListener {
            startActivity(Intent(this, ChatsActivity::class.java))
        }

        tabIcons[0].setOnClickListener { showTab(HomeFeedFragment()) }
        tabIcons[1].setOnClickListener { showTab(FriendsFragment()) }
        tabIcons[2].setOnClickListener { showTab(MarketplaceFragment()) }
        tabIcons[3].setOnClickListener { showTab(NotificationsFragment()) }
        tabIcons[4].setOnClickListener { showTab(MenuFragment()) }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val current = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                if (current !is HomeFeedFragment) {
                    showTab(HomeFeedFragment())
                } else {
                    finish()
                }
            }
        })
    }

    private fun showTab(fragment: Fragment) {
        val current = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (current != null && current.javaClass == fragment.javaClass) return
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        highlight(indexOf(fragment))
    }

    private fun indexOf(fragment: Fragment?): Int = when (fragment) {
        is FriendsFragment -> 1
        is MarketplaceFragment -> 2
        is NotificationsFragment -> 3
        is MenuFragment -> 4
        else -> 0
    }

    private fun highlight(selected: Int) {
        val teal = ContextCompat.getColor(this, R.color.kn_teal)
        val grey = ContextCompat.getColor(this, R.color.kn_text2)
        val dark = ContextCompat.getColor(this, R.color.kn_text)
        for (i in tabIcons.indices) {
            tabIcons[i].imageTintList = ColorStateList.valueOf(if (i == selected) teal else grey)
            indicators[i].visibility = if (i == selected) View.VISIBLE else View.INVISIBLE
        }
        headerTitle.text = titles[selected]
        if (selected == 0) {
            headerTitle.setTextColor(teal)
            headerTitle.typeface = Typeface.create("sans-serif-black", Typeface.NORMAL)
        } else {
            headerTitle.setTextColor(dark)
            headerTitle.typeface = Typeface.create("sans-serif", Typeface.BOLD)
        }
    }
}