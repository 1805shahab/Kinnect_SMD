package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_menu, container, false)

        root.findViewById<View>(R.id.menu_profile_row)?.setOnClickListener {
            startActivity(Intent(activity, ProfileActivity::class.java))
        }

        root.findViewById<View>(R.id.menu_logout_row)?.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return root
    }
}
