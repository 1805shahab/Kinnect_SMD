package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StoryViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_viewer)

        findViewById<TextView>(R.id.btnCloseStory).setOnClickListener {
            finish()
        }

        findViewById<View?>(R.id.avatarStory)?.setOnClickListener {
            startActivity(Intent(this, OtherProfileActivity::class.java))
        }
    }
}
