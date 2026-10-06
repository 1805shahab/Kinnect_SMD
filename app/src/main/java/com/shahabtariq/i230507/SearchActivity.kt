package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        findViewById<ImageButton?>(R.id.search_back)?.setOnClickListener { finish() }

        val peopleIds = listOf(R.id.personOmarFarooq, R.id.personOmarSiddiqui, R.id.personOmarTariq)
        for (id in peopleIds) {
            findViewById<View?>(id)?.setOnClickListener {
                startActivity(Intent(this, OtherProfileActivity::class.java))
            }
        }
    }
}
