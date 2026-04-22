package com.example.lifehackorurbanmythverifierapp

import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    lateinit var txtFinalScore: TextView
    lateinit var txtFeedback: TextView
    lateinit var btnReview: Button
    lateinit var btnRestart: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        txtFinalScore = findViewById(R.id.txtFinalScore)
        txtFeedback = findViewById(R.id.txtFeedback)
        btnReview = findViewById(R.id.btnReview)
        btnRestart = findViewById(R.id.btnRestart)

        // 3. Catch the score (The getIntExtra logic)
        val intScore = intent.getIntExtra("FINAL_SCORE", 0)
        Log.i("Navigation", "ScoreScreen opened. Final score received: $intScore")

        // Requirement: Using Toasts
        Toast.makeText(this, "Calculating results...", Toast.LENGTH_SHORT).show()

        // 4. Score Display (Rubric: Tracking and showing the score)
        txtFinalScore.text = "Final Result: $intScore / 10"

        // 5. Personalised Feedback (Rubric: if-else logic)
        if (intScore >= 8) {
            txtFeedback.text = "Master Hacker! You're an expert at spotting the truth."
            Log.d("FeedbackLogic", "High score message displayed.")
        } else if (intScore >= 5) {
            txtFeedback.text = "Great job! You have a solid eye for myths."
            Log.d("FeedbackLogic", "Medium score message displayed.")
        } else {
            txtFeedback.text = "Stay Safe Online! Keep practising your verification skills."
            Log.d("FeedbackLogic", "Low score message displayed.")
        }

        // 6. Review Button Logic (Rubric: Review questions and answers)
        btnReview.setOnClickListener {
            Log.i("UI_Action", "User clicked Review. Showing explanations.")

            // The Answer Key and Explanations
            val strReviewList = """
                CORRECT ANSWERS:
                1. Lemon/Apple: HACK (Acid stops browning)
                2. Frozen Candle: HACK (Burns slower)
                3. Tea bags in shoes: HACK (Absorbs odour)
                4. Olive oil/Fingerprint: HACK ( Cleans stainless steal)
                5. Wooden spoon /Boiling pot: HACK (Prevents the water from boing over)
                6. Knuckle Cracking: MYTH (Just gas bubbles, It does not cause athritis )
                7. Gum/Stomach: MYTH (It does not stay in your stoamch for 7 years)
                8. Carrots/Vision: MYTH (Does not improve night vision)
                9. Rice/Phone: MYTH (It is too slow to absorb internal moisture)
                10. Batteries in the Fridge: MYTH (Does not make the batteries last longer)
            """.trimIndent()

            // SWAP: Put the review list into the feedback text box
            txtFeedback.text = strReviewList

            // Hide the button after it's clicked
            btnReview.visibility = View.GONE
            Toast.makeText(this, "Showing Explanations", Toast.LENGTH_SHORT).show()
        }

        // 7. Restart Button Logic
        btnRestart.setOnClickListener {
            Log.i("Navigation", "Restarting quiz. Navigating to Welcome Screen.")
            val intentRestart = Intent(this, WelcomeScreen::class.java)
            startActivity(intentRestart)
            finish()
        }
    }
}






