package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class OtherProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_profile)

        findViewById<View?>(R.id.other_profile_back)?.setOnClickListener { finish() }

        findViewById<View?>(R.id.btn_message_other)?.setOnClickListener {
            startActivity(Intent(this, ChatThreadActivity::class.java))
        }
    }
}