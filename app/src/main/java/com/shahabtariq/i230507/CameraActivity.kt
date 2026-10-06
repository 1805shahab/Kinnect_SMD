package com.shahabtariq.i230507

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {

    private val editorLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            startActivity(Intent(this, YourStoryActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        findViewById<ImageButton?>(R.id.camera_close)?.setOnClickListener { finish() }

        findViewById<View>(android.R.id.content).setOnClickListener {
            editorLauncher.launch(Intent(this, StoryEditorActivity::class.java))
        }
    }
}
