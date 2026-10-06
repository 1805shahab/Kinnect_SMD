package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_thread)

        findViewById<View?>(R.id.tvChatBack)?.setOnClickListener { finish() }

        findViewById<View?>(R.id.avatarWrapChat)?.setOnClickListener {
            startActivity(Intent(this, OtherProfileActivity::class.java))
        }

        findViewById<TextView?>(R.id.btnVoiceCall)?.setOnClickListener {
            startActivity(Intent(this, VoiceCallActivity::class.java))
        }
    }
}
