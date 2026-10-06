package com.shahabtariq.i230507

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class StoryEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_editor)

        findViewById<ImageButton?>(R.id.story_editor_close)?.setOnClickListener { finish() }
        findViewById<View?>(R.id.story_editor_share)?.setOnClickListener { finish() }
    }
}
