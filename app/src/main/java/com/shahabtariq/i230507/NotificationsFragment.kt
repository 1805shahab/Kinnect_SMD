package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        val notifIds = listOf(
            R.id.notifAisha,
            R.id.notifSara,
            R.id.notifZain,
            R.id.notifHamza,
            R.id.notifLina
        )
        for (id in notifIds) {
            root.findViewById<View?>(id)?.setOnClickListener {
                startActivity(Intent(activity, OtherProfileActivity::class.java))
            }
        }

        return root
    }
}
