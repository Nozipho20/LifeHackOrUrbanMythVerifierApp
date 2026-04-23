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

        // This is the intent created so that we can catch the score using (The getIntExtra logic)
        val intScore = intent.getIntExtra("FINAL_SCORE", 0)
        Log.i("Navigation", "ScoreScreen opened. Final score received: $intScore")

        // This Toast will pop up after the results are being calculated
        Toast.makeText(this, "Calculating results...", Toast.LENGTH_SHORT).show()

        // This is the Score Display that is Tracking and showing the score
        txtFinalScore.text = "Final Result: $intScore / 10"

        // The Personalised Feedback that the user gets based on the score that they obtained
        // The if-else logic is used to navigate to the next feedback
        // I lso utilized logs through out of the if else logic to track everything
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

        //The Review button logic allows users to review all questions and their correct answers

        btnReview.setOnClickListener {
            Log.i("UI_Action", "User clicked Review. Showing explanations.")

            // We are Using a StringBuilder to build the list line by line professionally ans prove answers
            val builder = StringBuilder()

            builder.append("CORRECT ANSWERS & EXPLANATIONS:\n\n")
            builder.append("1. Lemon/Apple: HACK. The acid stops the fruit from browning.\n\n")
            builder.append("2. Frozen Candle: HACK. It helps the wax burn much slower.\n\n")
            builder.append("3. Tea bags in shoes: HACK. The leaves naturally absorb bad odours.\n\n")
            builder.append("4. Olive oil: HACK. It effectively cleans fingerprints off stainless steel.\n\n")
            builder.append("5. Wooden spoon: HACK. It prevents water from boiling over the pot.\n\n")
            builder.append("6. Knuckle Cracking: MYTH. It is just gas bubbles and does not cause arthritis.\n\n")
            builder.append("7. Gum in stomach: MYTH. It does not stay for 7 years; it is digested normally.\n\n")
            builder.append("8. Carrots/Vision: MYTH. They are healthy but do not give you night vision.\n\n")
            builder.append("9. Rice/Phone: MYTH. It is too slow to absorb moisture and adds harmful dust.\n\n")
            builder.append("10. Batteries in Fridge: MYTH. It doesn't extend life and can cause rust.\n")

            // This simply Converts the builder that is created into a String and displays it
            txtFeedback.text = builder.toString()

            // This logic hides the Review button after it's clicked and shows a Toast
            btnReview.visibility = View.GONE
            Toast.makeText(this, "Showing Explanations", Toast.LENGTH_SHORT).show()
        }

        // This is the Restart Button Logic that allows you to start the quiz all over again
        btnRestart.setOnClickListener {
            Log.i("Navigation", "Restarting quiz. Navigating to Welcome Screen.")
            val intentRestart = Intent(this, WelcomeScreen::class.java)
            startActivity(intentRestart)
            finish()
        }}}