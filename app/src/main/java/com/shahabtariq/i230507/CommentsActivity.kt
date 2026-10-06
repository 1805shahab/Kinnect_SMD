package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CommentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        findViewById<TextView>(R.id.tvCommentsBack).setOnClickListener {
            finish()
        }

        val commentIds = listOf(
            R.id.commentAisha,
            R.id.commentLina,
            R.id.commentZain,
            R.id.commentHamza,
            R.id.commentMaya
        )
        for (id in commentIds) {
            findViewById<View?>(id)?.setOnClickListener {
                startActivity(Intent(this, OtherProfileActivity::class.java))
            }
        }
    }
}
