package com.example.lifehackorurbanmythverifierapp

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Toast
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class FlashcardQuestionScreen : AppCompatActivity() {
    lateinit var txtQuestion: TextView
    lateinit var txtScore: TextView
    lateinit var rgChoices: RadioGroup
    lateinit var rbHack: RadioButton
    lateinit var rbMyth: RadioButton
    lateinit var btnNext: Button


    // Iteration variables
    var intScore: Int = 0
    var intIndex: Int = 0


    // 10 Chosen Items (5Hacks, 5Myths)
    val arrQuestions = arrayOf(
        "Squeezing a lemon over a cut apple stops it from browning",
        "Freezing a candle before use makes it burn slower and last longer",
        "Putting dry tea bags in smelly shoes removes odour",
        "Rubbing a stainless steel surface with olive oil removes fingerprints",
        "Putting a wooden spoon across a boiling pot stops it from boiling over",
        "Cracking your knuckles causes arthritis",
        "Swallowed gum stays in your stomach for 7 years",
        "Eating carrots improves your night vision",
        "Putting a wet phone in rice helps dry it out",
        "Keeping batteries in the fridge makes them last longer"
    )


    // True = Hack, False = Myth
    val arrAnswers = arrayOf(
        0, 0, 0, 0, 0, // First 5 are Hacks
        1, 1, 1, 1, 1  // Last 5 are Myths
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_question_screen)
        // Initializing views using txt/btn prefixes
        txtQuestion = findViewById(R.id.txtQuestion)
        txtScore = findViewById(R.id.txtScore)
        rgChoices = findViewById(R.id.rgChoices)
        rbHack = findViewById(R.id.rbHack)
        rbMyth = findViewById(R.id.rbMyth)
        btnNext = findViewById(R.id.btnNext)


        txtQuestion.text = arrQuestions[intIndex]
        txtScore.text = "Score: $intScore"
        Log.d("QuizLoop", "App started. Displaying question at index 0")

        btnNext.setOnClickListener {
            // Get the selected RadioButton ID from the group
            val selectedId = rgChoices.checkedRadioButtonId

            if (selectedId == -1) {
                // Feedback for no selection
                Toast.makeText(this, "Please select an answer first!", Toast.LENGTH_SHORT).show()
                Log.w("QuizLogic", "User clicked Next without selecting an option")
            } else {
                // Determine user selection (0 for Hack, 1 for Myth)
                val userSelection = if (selectedId == R.id.rbHack) 0 else 1

                // 2 & 3. Scoring Logic and Feedback
                if (userSelection == arrAnswers[intIndex]) {
                    intScore++
                    Toast.makeText(this, "Correct! Well done.", Toast.LENGTH_SHORT).show()
                    Log.d("QuizProgress", "Correct selection at index $intIndex. New Score: $intScore")
                } else {
                    Toast.makeText(this, "Wrong! Better luck next time.", Toast.LENGTH_SHORT).show()
                    Log.d("QuizProgress", "Incorrect selection at index $intIndex")
                }

                // 4. Move to next question logic
                intIndex++
                Log.i("QuizLoop", "Moving index to: $intIndex")

                if (intIndex < arrQuestions.size) {
                    // Update screen for next question directly
                    txtQuestion.text = arrQuestions[intIndex]
                    txtScore.text = "Score: $intScore"
                    rgChoices.clearCheck() // Reset radio buttons for next item
                } else {
                    // Final navigation to Screen 3 (Score Screen)
                    Log.i("QuizComplete", "Finished all questions. Navigating to ScoreScreen with score: $intScore")

                    val intent = Intent(this, ScoreScreen::class.java)
                    intent.putExtra("FINAL_SCORE", intScore)
                    startActivity(intent)
                    finish()
                }
            }
        }}}




