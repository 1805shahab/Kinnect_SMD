package com.shahabtariq.i230507

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class YourStoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_story)

        findViewById<ImageButton?>(R.id.your_story_close)?.setOnClickListener { finish() }
    }
}
