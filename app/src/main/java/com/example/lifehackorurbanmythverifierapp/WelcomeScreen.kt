package com.example.lifehackorurbanmythverifierapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import android.content.Intent
import android.util.Log


class WelcomeScreen : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var txtWelcome: TextView
    lateinit var txtDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.welcomescreen)
        btnStart = findViewById(R.id.btnStart)
        txtWelcome = findViewById(R.id.txtWelcome)
        txtDescription = findViewById(R.id.txtDescription)

        // LOG: Confirms screen initialization
        Log.d("LifeHackVerify", "MainActivity: Welcome screen loaded successfully.")

        btnStart.setOnClickListener {
            // LOG: Shows the button interaction in Logcat
            Log.d("LifeHackVerify", "User clicked btnStart. Preparing to navigate.")

            // Toast feedback for the user
            Toast.makeText(this, "Loading your 14 cards... Good luck!", Toast.LENGTH_SHORT).show()

            // Intent logic to move to the second screen
            val intent = Intent(this, FlashcardQuestionScreen ::class.java)
            startActivity(intent)

            // LOG: Confirms successful navigation
            Log.i("Navigation", "Output: Moving to the Question Screen.")










            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}