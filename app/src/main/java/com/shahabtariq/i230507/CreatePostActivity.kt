package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreatePostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        findViewById<TextView>(R.id.btnClosePost).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnSubmitPost).setOnClickListener { finish() }

        findViewById<TextView>(R.id.tvOptionPhotoPicker).setOnClickListener {
            startActivity(Intent(this, PhotoPickerActivity::class.java))
        }
    }
}
