package com.shahabtariq.i230507

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FriendsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_friends, container, false)

        val rows = listOf<Int>(R.id.rowSara, R.id.rowBilal, R.id.rowNoor, R.id.rowDaniyal)
        for (id in rows) {
            setClickToOpenProfile(root.findViewById<View?>(id))
        }
        return root
    }

    private fun setClickToOpenProfile(view: View?) {
        if (view == null) return
        view.setOnClickListener {
            startActivity(Intent(activity, OtherProfileActivity::class.java))
        }
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                setClickToOpenProfile(view.getChildAt(i))
            }
        }
    }
}
