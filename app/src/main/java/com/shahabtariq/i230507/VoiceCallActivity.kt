package com.shahabtariq.i230507

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class VoiceCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_call)

        findViewById<View?>(R.id.btn_end_call)?.setOnClickListener { finish() }
    }
}
