Comprehensive report detailing the purpose of the app, its design considerations and the utilisation of GitHub Actions:

THE PURPOSE OF THE APP The Application is intended to serve the following functions: Life Hack or Urban Myth Verifier App is an Android native app written in Kotlin in Android Studio. I designed the app to address a contemporary issue that is a reality. The internet is full with viral life hacks most of which are entirely fake. Users find it challenging to distinguish authentic productivity tips and the myths that have proliferated all over the Internet having no foundation in truth. The application addresses this by showing 10 statements, 5 real life hacks and 5 urban myths, in a quiz format of flashcards. The user will distinguish between all the statements as a Hack (True) and Myth (False), will be provided with instant feedback and scorekeeping and at the conclusion will be allowed to review all of the correct answers with explanations. This transforms a dull scroll into a lively learning process.

DESIGN CONSIDERATIONS Screen 1 -The Welcome Screen The background of all three screens has a uniform teal gradient that ensures that there is visual harmony. At the top is a bold dark banner with the title. To indicate critical thinking, a brain/gear icon was selected. Two ornamental images (a lightbulb and a down arrow) direct the eye to the START QUIZ button on the bottom. A squarish button styling was selected to give it a clean modern appearance. The welcome text provides a clear description of the app prior to any action by the user, which is a good practice in UX. Screen 2 - Flashcard Question Screen. The Score label is framed by two icon images at the top, which make the screen look like a game. The text of the question is big, bold and in capital. The two RadioButtons are intentionally colour-coded; green with a checkmark emoji for LIFE HACK (TRUE) and red with a ghost emoji for URBANMYTH (FALSE). This colour language is natural and does not need any training. The lightning bolt image is a visual appeal in between the options and Next button, which is designed in indigo/purple to contrast. Screen 3 -THE SCORE SCREEN The final score is written in bold italic orange writing - a warm celebratory colour. The feedback box is in a cream/yellow color to be distinct against the screen of the teal. At the bottom, there are side by side the Review and Restart buttons. The image of a crown below the buttons commemorates the fact that the user is done with the quiz - another minor detail that brings joy to the process.

APPLICATION LOGIC Welcome Screen: Button click - Logs to verify that you have interacted with the welcome screen, Toast message states that you are loading your 10 cards, you are lucky!, Intent action goes to the Question Screen, second Log confirms navigation. Question Screen - Loop Logic: The quiz is driven by two arrays; arrQuestions (10 question strings) and arrAnswers (10 integers 0 Hack, 1 Myth). The loop is driven by two counters intScore and intIndex, which both have a starting point of zero. Rather than using a for-loop, intIndex will be a pointer, advancing each time the Next button is pressed, which is ideally suited to the Android event-driven paradigm. Next button: This confirms that the user has made a selection, and makes comparisons between the user choice and the arrAnswers[intIndex], and also increments intScore in case of a correct answer, displays a Toast in any case, and advances intIndex to the next question rgChoices.question 10 with intent, and goes to Score Screen.putExtra("FINAL_SCORE", intScore). Score Screen: getIntExtra("FINAL_SCORE, 0) gets the score - the default 0 is defensive programming in case the extra is not there. A series of if-else statements produces individualised feedback: 810 repeats Master Hacker!, 57 repeats Great job!, less than 5 repeats Stay Safe Online!. The Review button involves the creation of all 10 possible answers and explanations, line by line, using a StringBuilder followed by the setting of btnReview.visibility = View.REMOVED on clicking the button to stop repeat presses. The Restart button invokes a new Intent to the Welcome Screen and invokes finish() to clear the back stack. Coding Standards: Name descriptive variables all the way through. Each large block of code contains a comment. The level of Log.d, Log.i and Log.w are used deliberately - debug level used to check the state, info level to find the way, warning level to report errors of the user. All interaction points feature toast feedback. There is no superfluous logic and code complexity is maintained low.

GitHub and GitHub Actions. Version Control: Kotlin source code and XML layouts were added and also pushed to a GitHub repository - no zip files. Numerous commits were done across the development process with descriptive commit messages, which made a traceable history of the development of the project. A README.md file was the first file in the repository. GitHub Actions: A build.yml workflow file is in the directory of.github/workflows/. Each commit to the repository will cause an automatic Android build on a clean isolated system. It demonstrates that the app can assemble successfully not on the local machine only, which is a common Continuous Integration (CI) behavior of professional Android development. Each build is registered in the Actions tab of the repository. README file: The README provides the description of the app, all of the three screen overviews, logic flow, table of all 10 questions and answers, design choices, testing notes, a video demonstration link, and student information. It was formatted with images and made professional to look clear.

SCREENSHOTS OF MY APP
THE WELCOME SCREEN THE SCORE SCREEN

When you press the Next button and did not choose either of the radio buttons

When you choose a wrong answer
When you choose a correct answer

When the user gets less than
   5 points there is a feedback
The correct answers appear when you press review

The comment when you get a higher points above 8

                                                                 The comment when you get less than 8                 	                                                          points                        
LINK TO THE EMGPPT Assignment 2 https://github.com/EMGPPT/imad5112-g1-2026-assignment2-Nozipho20

LINK TO THE GITHUB REPISOTORY https://github.com/Nozipho20/LifeHackOrUrbanMythVerifierApp

LINK TO THE YOUTUBE VIDEO OF ME DEMOSTRATING HOW THE APP WORKS https://youtu.be/1gjp-3BNX6U

REFERENCE LIST

The Independent Institute of Education, 2026. Introduction to mobile application and web development [IMAD5112]. nt. [online via internal VLE] The Independent Institute of Education. Available at: <Learning Unit 5: Arrays – IMAD5112: Introduction to mobile application and web development> [Accessed Date 23 April 2025].

Smartherd, 2016. #12 Android LogCat tutorial: Android Studio part – 2. [video online] Available at: https://youtu.be/QqjrR11tuz0?si=ODGvGgObkT_5oyxu [Accessed 21 March 2026]. Kotlin Docs, 2024. Control flow: if, when, for, while. [online] Available at: https://kotlinlang.org/docs/control-flow.html [Accessed 21 March 2026].

Android Developers, 2024. Toasts overview. [online] Available at: https://developer.android.com/guide/topics/ui/notifiers/toasts [Accessed 21 March 2026].

Android Developers, 2024. Buttons. [online] Available at: https://developer.android.com/develop/ui/views/components/button [Accessed 21 March 2026].

About
imad5112-g1-2026-assignment2-Nozipho20 created by GitHub Classroom

Resources
 Readme
 Activity
 Custom properties
Stars
 0 stars
Watchers
 0 watching
Forks
 0 forks
Releases
No releases published
Create a new release
Packages
No packages published
Publish your first package
Contributors
1
@Nozipho20
Nozipho20
Languages
Kotlin
100.0%
Footer
© 2026 GitHub, Inc.
Footer navigation
Terms
Privacy
