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


class FlashcardQuestionScreen : AppCompatActivity() {
    lateinit var txtQuestion: TextView
    lateinit var txtScore: TextView
    lateinit var rgChoices: RadioGroup
    lateinit var rbHack: RadioButton
    lateinit var rbMyth: RadioButton
    lateinit var btnNext: Button


    // On this section we are iterating the variables
    var intScore: Int = 0
    var intIndex: Int = 0


    // These are the 10 chosen Questions ,5 hacks and 5 myths .This Displays the quizzes to the user using a loop
    val arrQuestions = arrayOf(
        "1.Squeezing a lemon over a cut apple stops it from browning",
        "2.Freezing a candle before use makes it burn slower and last longer",
        "3.Putting dry tea bags in smelly shoes removes odour",
        "4.Rubbing a stainless steel surface with olive oil removes fingerprints",
        "5.Putting a wooden spoon across a boiling pot stops it from boiling over",        // Referencece: [1]
        "6.Cracking your knuckles causes arthritis",
        "7.Swallowed gum stays in your stomach for 7 years",
        "8.Eating carrots improves your night vision",
        "9.Putting a wet phone in rice helps dry it out",
        "10.Keeping batteries in the fridge makes them last longer"
    )


    // This displays the answers to the question working like this: 0= Hack, 1 = Myth
    val arrAnswers = arrayOf(
        0, 0, 0, 0, 0, // First 5 are Hacks
        1, 1, 1, 1, 1  // Last 5 are Myths
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_question_screen)
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
            // This logic Gets the selected RadioButton ID from the from the Radio Group
            val selectedId = rgChoices.checkedRadioButtonId

            if (selectedId == -1) {
                // Feedback for no selection
                Toast.makeText(this, "Please select an answer first!", Toast.LENGTH_SHORT).show()
                Log.w("QuizLogic", "User clicked Next without selecting an option")
            } else {
                // This helps Determine user selection (0 for Hack, 1 for Myth)
                val userSelection = if (selectedId == R.id.rbHack) 0 else 1

                // This indicates Scoring Logic and Feedback using intIndex
                if (userSelection == arrAnswers[intIndex]) {
                    intScore++
                    Toast.makeText(this, "Correct! Well done.", Toast.LENGTH_SHORT).show()   //Use toast to give remarks   // Reference: [2]
                    Log.d("QuizProgress", "Correct selection at index $intIndex. New Score: $intScore")
                } else {
                    Toast.makeText(this, "Wrong! Better luck next time.", Toast.LENGTH_SHORT).show()
                    Log.d("QuizProgress", "Incorrect selection at index $intIndex")
                }

                // This logic alllows you move on to next question logic
                intIndex++
                Log.i("QuizLoop", "Moving index to: $intIndex")

                if (intIndex < arrQuestions.size) {
                    //This Updates the screen for the next question directly using intIndex
                    txtQuestion.text = arrQuestions[intIndex]  // using intIndex
                    txtScore.text = "Score: $intScore"
                    rgChoices.clearCheck() // Using this to reset the radio buttons
                } else {
                    // The Final navigation to Screen 3 on which is the log Screen
                    Log.i("QuizComplete", "Finished all questions. Navigating to ScoreScreen with score: $intScore") // Using Logs to track proplems

                    val intent = Intent(this, ScoreScreen::class.java)
                    intent.putExtra("FINAL_SCORE", intScore)
                    startActivity(intent)
                    finish()
                }
            }
        }}}
// Reference list
// [1] The Independent Institute of Education, 2026. Introduction to mobile application and web development [IMAD5112]. nt. [online via internal VLE] The Independent Institute of Education. Available at: <Learning Unit 5: Arrays – IMAD5112: Introduction to mobile application and web development> [Accessed Date 23 April 2025].
// [2] Android Developers, 2024. Toasts overview. [online] Available at: https://developer.android.com/guide/topics/ui/notifiers/toasts [Accessed 21 March 2026].




