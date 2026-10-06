package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btnLogin).setOnClickListener { goHome() }
        findViewById<LinearLayout>(R.id.llRecentLogin).setOnClickListener { goHome() }

        // Login stays in the back stack so Back from Sign up returns here
        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun goHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}