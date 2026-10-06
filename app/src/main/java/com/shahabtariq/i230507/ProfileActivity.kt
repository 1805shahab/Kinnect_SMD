package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<View?>(R.id.ivProfileBack)?.setOnClickListener { finish() }

        findViewById<View?>(R.id.btnEditProfile)?.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

        findViewById<View?>(R.id.btnAddStory)?.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }
    }
}