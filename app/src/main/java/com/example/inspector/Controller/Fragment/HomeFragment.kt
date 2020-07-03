package com.example.inspector.Controller.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.inspector.R
import com.example.inspector.Utils.Utils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private val TAG = "HomeFragment"
    private lateinit var welcomeTextView: TextView
    private lateinit var controlCarView: CardView
    private lateinit var roomCarView: CardView
    private lateinit var toolCarView: CardView

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        auth = FirebaseAuth.getInstance()
        welcomeTextView = root.findViewById(R.id.welcomeUserTextView)
        controlCarView = root.findViewById(R.id.controlCardview)
        roomCarView = root.findViewById(R.id.roomCardView)
        toolCarView = root.findViewById(R.id.toolCardView)
        setupUI(auth.currentUser)
        configureClicks()
        return root
    }

    fun setupUI(currentUser: FirebaseUser?) {
        val user = currentUser?.displayName
        val welcomeSting = getString(R.string.home_welcomeUser, user)
        welcomeTextView.text = welcomeSting
    }

    fun configureClicks() {
        controlCarView.setOnClickListener {
            val controlTitle = getString(R.string.home_control_form)
            Utils.alert("$controlTitle não foi implementado ainda!")
        }

        roomCarView.setOnClickListener {
            val roomTitle = getString(R.string.home_room_form)
            Utils.alert("$roomTitle não foi implementado ainda!")
        }

        toolCarView.setOnClickListener {
            val toolTitle = getString(R.string.home_tool_form)
            Utils.alert("$toolTitle não foi implementado ainda!")
        }

    }

}
