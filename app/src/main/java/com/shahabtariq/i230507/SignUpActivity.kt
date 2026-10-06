package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<TextView>(R.id.tvBackSignUp).setOnClickListener { finish() }
        findViewById<TextView>(R.id.tvBackToLogin).setOnClickListener { finish() }

        findViewById<Button>(R.id.btnSubmitSignUp).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}