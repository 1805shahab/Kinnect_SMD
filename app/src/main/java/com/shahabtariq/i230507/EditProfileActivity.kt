package com.shahabtariq.i230507

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        findViewById<View?>(R.id.edit_profile_back)?.setOnClickListener { finish() }
        findViewById<View?>(R.id.edit_profile_save)?.setOnClickListener { finish() }
    }
}