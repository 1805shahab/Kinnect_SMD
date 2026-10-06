package com.shahabtariq.i230507

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class HomeFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home_feed, container, false)

        root.findViewById<TextView>(R.id.tvWhatsOnYourMind)?.setOnClickListener {
            startActivity(Intent(activity, CreatePostActivity::class.java))
        }

        root.findViewById<RelativeLayout>(R.id.cardCreateStory)?.setOnClickListener {
            startActivity(Intent(activity, CameraActivity::class.java))
        }

        val storyViewerIds = listOf(
            R.id.cardOmarStory,
            R.id.cardSaraStory,
            R.id.cardHamzaStory,
            R.id.cardAishaStory
        )
        for (id in storyViewerIds) {
            root.findViewById<View?>(id)?.setOnClickListener {
                startActivity(Intent(activity, StoryViewerActivity::class.java))
            }
        }

        root.findViewById<TextView>(R.id.ivMyProfileIcon)?.setOnClickListener {
            startActivity(Intent(activity, ProfileActivity::class.java))
        }

        root.findViewById<Button>(R.id.btnOpenComments)?.setOnClickListener {
            startActivity(Intent(activity, CommentsActivity::class.java))
        }

        root.findViewById<TextView>(R.id.tvPostCommentsCount)?.setOnClickListener {
            startActivity(Intent(activity, CommentsActivity::class.java))
        }

        root.findViewById<View>(R.id.postHeader)?.setOnClickListener {
            startActivity(Intent(activity, OtherProfileActivity::class.java))
        }

        val btnLike = root.findViewById<TextView>(R.id.btnLike)
        btnLike?.setOnClickListener {
            if (btnLike.text.toString().contains("Like")) {
                if (btnLike.text == "Like") {
                    btnLike.text = "👍 Like"
                    btnLike.setTextColor(ContextCompat.getColor(requireContext(), R.color.kn_teal))
                } else {
                    btnLike.text = "Like"
                    btnLike.setTextColor(ContextCompat.getColor(requireContext(), R.color.kn_text2))
                }
            } else {
                btnLike.text = "Like"
                btnLike.setTextColor(ContextCompat.getColor(requireContext(), R.color.kn_text2))
            }
        }

        btnLike?.setOnLongClickListener {
            showReactionPicker(it)
            true
        }

        return root
    }

    private fun showReactionPicker(anchorView: View) {
        val context = context ?: return
        val popupView = LayoutInflater.from(context).inflate(R.layout.popup_reaction_picker, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )
        popupWindow.elevation = 16f

        val btnLike = anchorView as? TextView

        fun selectReaction(text: String, colorHex: String) {
            btnLike?.text = text
            btnLike?.setTextColor(Color.parseColor(colorHex))
            popupWindow.dismiss()
        }

        popupView.findViewById<View?>(R.id.react_like)?.setOnClickListener {
            selectReaction("👍 Like", "#008080")
        }
        popupView.findViewById<View?>(R.id.react_love)?.setOnClickListener {
            selectReaction("❤️ Love", "#E53935")
        }
        popupView.findViewById<View?>(R.id.react_haha)?.setOnClickListener {
            selectReaction("😆 Haha", "#FBC02D")
        }
        popupView.findViewById<View?>(R.id.react_wow)?.setOnClickListener {
            selectReaction("😮 Wow", "#FBC02D")
        }
        popupView.findViewById<View?>(R.id.react_sad)?.setOnClickListener {
            selectReaction("😢 Sad", "#FBC02D")
        }
        popupView.findViewById<View?>(R.id.react_angry)?.setOnClickListener {
            selectReaction("😡 Angry", "#E65100")
        }

        popupView.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        val popupHeight = popupView.measuredHeight
        val popupWidth = popupView.measuredWidth

        val location = IntArray(2)
        anchorView.getLocationOnScreen(location)
        val x = location[0] + (anchorView.width / 2) - (popupWidth / 2)
        val y = location[1] - popupHeight - 12

        popupWindow.showAtLocation(anchorView, Gravity.NO_GRAVITY, x, y)
    }
}