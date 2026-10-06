package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ChatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)

        findViewById<View?>(R.id.btnBack)?.setOnClickListener { finish() }

        findViewById<View?>(R.id.chat_list_container)?.setOnClickListener {
            startActivity(Intent(this, ChatThreadActivity::class.java))
        }
    }
}
