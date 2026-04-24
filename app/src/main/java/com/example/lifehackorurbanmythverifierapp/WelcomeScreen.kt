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

        // This log that is created here confirms the screen initialization
        Log.d("LifeHackVerify", "MainActivity: Welcome screen loaded successfully.")     // Reference: [1]

        btnStart.setOnClickListener {
            // This log shows the button interaction in Logcat
            Log.d("LifeHackVerify", "User clicked btnStart. Preparing to navigate.")     // Reference: [1]

            //This is the toast for the user
            Toast.makeText(this, "Loading your 10 cards... Good luck!", Toast.LENGTH_SHORT).show()     // Reference: [2]

            //The Intent logic created so we can move and navigate to the second screen
            val intent = Intent(this, FlashcardQuestionScreen ::class.java)
            startActivity(intent)

            // This Log confirms the successful navigation to the Question Screen
            Log.i("Navigation", "Output: Moving to the Question Screen.")         // Reference: [1]










            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}

// Reference list
// [1] The Independent Institute of Education, 2026. Introduction to mobile application and web development [IMAD5112]. nt. [online via internal VLE] The Independent Institute of Education. Available at: <Learning Unit 5: Arrays – IMAD5112: Introduction to mobile application and web development> [Accessed Date 23 April 2025].
// [2] Android Developers, 2024. Toasts overview. [online] Available at: https://developer.android.com/guide/topics/ui/notifiers/toasts [Accessed 21 March 2026].
