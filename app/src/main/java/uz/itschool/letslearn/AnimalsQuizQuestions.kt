package uz.itschool.letslearn
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


class AnimalsQuizQuestions : AppCompatActivity(), View.OnClickListener {

    private lateinit var an_v1: ImageView
    private lateinit var an_v2: ImageView
    private lateinit var an_v3: ImageView
    private lateinit var an_v4: ImageView

    private lateinit var an_question: TextView
    private lateinit var an_mainword: TextView
    private lateinit var an_submit: TextView
    private lateinit var an_progress: TextView
    private lateinit var an_progressBar: ProgressBar

    private var index = 0
    private val picturetests = mutableListOf<AnimalsQuestions>()
    private var selectedOptionPosition = 0
    private var score = 0
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz_questions)

        // Initialize views after setContentView
        an_v1 = findViewById(R.id.an_v1)
        an_v2 = findViewById(R.id.an_v2)
        an_v3 = findViewById(R.id.an_v3)
        an_v4 = findViewById(R.id.an_v4)
        an_question = findViewById(R.id.an_question)
        an_mainword = findViewById(R.id.an_mainword)
        an_submit = findViewById(R.id.an_submit)
        an_progress = findViewById(R.id.an_progress)
        an_progressBar = findViewById(R.id.an_progressBar)

        username = intent.getStringExtra(Constants.UserName)

        picturetests.addAll(
            listOf(
                AnimalsQuestions("Choose the animal", "Snake", R.drawable.lion, R.drawable.fox, R.drawable.snake, R.drawable.bear, 3),
                AnimalsQuestions("Choose the animal", "Elephant", R.drawable.elephant, R.drawable.zebra, R.drawable.snake, R.drawable.monkey, 1),
                AnimalsQuestions("Choose the animal", "Crocodile", R.drawable.giraffe, R.drawable.crocodile, R.drawable.deer, R.drawable.fox, 2),
                AnimalsQuestions("Choose the animal", "Bear", R.drawable.monkey, R.drawable.elephant, R.drawable.lion, R.drawable.bear, 4),
                AnimalsQuestions("Choose the animal", "Deer", R.drawable.fox, R.drawable.snake, R.drawable.zebra, R.drawable.deer, 4),
                AnimalsQuestions("Choose the animal", "Monkey", R.drawable.monkey, R.drawable.elephant, R.drawable.giraffe, R.drawable.snake, 1),
                AnimalsQuestions("Choose the animal", "Fox", R.drawable.lion, R.drawable.fox, R.drawable.zebra, R.drawable.bear, 2)
            )
        )

        an_v1.setOnClickListener(this)
        an_v2.setOnClickListener(this)
        an_v3.setOnClickListener(this)
        an_v4.setOnClickListener(this)

        createTest(index)

        an_submit.setOnClickListener {

            if (selectedOptionPosition != 0) {
                val question = picturetests[index]
                if (question.correctAnswer != selectedOptionPosition) {
                    AnswerView(selectedOptionPosition, R.drawable.wronganswer)
                } else {
                    score++
                    AnswerView(selectedOptionPosition, R.drawable.correctanswer)
                }

                if (index == picturetests.size - 1) {
                    an_submit.text = "FINISH"
                } else {
                    an_submit.text = "Go to next"
                }
                index++
            } else {
                when {
                    index <= picturetests.size - 1 -> {
                        createTest(index)
                    }
                    else -> {
                        val intent = Intent(this, ResultAnimalsQuiz::class.java)
                        intent.putExtra(Constants.UserName, username.toString())
                        intent.putExtra(Constants.Score, score)
                        intent.putExtra(Constants.TotalQues, picturetests.size)
                        startActivity(intent)
                        finish()
                    }
                }
            }

            selectedOptionPosition = 0

        }
    }

    private fun createTest(index: Int) {
        val test: AnimalsQuestions = picturetests[index]
        an_question.text = test.question
        an_progressBar.progress = index + 1
        an_progressBar.max = picturetests.size
        an_progress.text = "${index + 1}" + "/" + "${picturetests.size}"
        an_mainword.text = test.mainword
        an_v1.setImageResource(test.v1)
        an_v2.setImageResource(test.v2)
        an_v3.setImageResource(test.v3)
        an_v4.setImageResource(test.v4)
    }

    private fun AnswerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                an_v1.setImageResource(drawableView)
            }
            2 -> {
                an_v2.setImageResource(drawableView)
            }
            3 -> {
                an_v3.setImageResource(drawableView)
            }
            4 -> {
                an_v4.setImageResource(drawableView)
            }
        }
    }

    private fun selectedOptionStyle(image: ImageView, opt: Int) {
        selectedOptionPosition = opt
        image.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        view?.let {
            when (it.id) {
                R.id.an_v1 -> {
                    selectedOptionStyle(an_v1, 1)
                }
                R.id.an_v2 -> {
                    selectedOptionStyle(an_v2, 2)
                }
                R.id.an_v3 -> {
                    selectedOptionStyle(an_v3, 3)
                }
                R.id.an_v4 -> {
                    selectedOptionStyle(an_v4, 4)
                }
            }
        }
    }
}
