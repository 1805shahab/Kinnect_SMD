package com.shahabtariq.i230507

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhotoPickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_picker)

        findViewById<TextView>(R.id.tvCancelPhotoPicker).setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        findViewById<TextView>(R.id.tvNextPhotoPicker).setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra("selected_count", 2))
            finish()
        }
    }
}