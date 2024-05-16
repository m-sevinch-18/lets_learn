package uz.itschool.letslearn
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class FruitsQuizQuestionsActivity : AppCompatActivity(){

    private lateinit var btn_submit: Button
    private lateinit var tv_v1: TextView
    private lateinit var tv_v2: TextView
    private lateinit var tv_v3: TextView
    private lateinit var tv_v4: TextView

    private lateinit var iv_image: ImageView
    private lateinit var tv_question: TextView
    private lateinit var tv_progress: TextView
    private lateinit var progressBar: ProgressBar

    private var UserName: String? = null
    private var currentPosition = 1
    private var questionList: MutableList<FruitsQuestions>? = null
    private var selectedOption = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_quiz_questions)

        btn_submit = findViewById(R.id.btn_submit)
        tv_v1 = findViewById(R.id.tv_v1)
        tv_v2 = findViewById(R.id.tv_v2)
        tv_v3 = findViewById(R.id.tv_v3)
        tv_v4 = findViewById(R.id.tv_v4)
        iv_image = findViewById(R.id.iv_image)
        tv_question = findViewById(R.id.tv_question)
        tv_progress = findViewById(R.id.tv_progress)
        progressBar = findViewById(R.id.progressBar)

        UserName = intent.getStringExtra(Constants.USERNAME)
        questionList = Constants.getQuestions()

        setQuestion()

        tv_v1.setOnClickListener {
            selectedOptionStyle(tv_v1, 1)
        }
        tv_v2.setOnClickListener {
            selectedOptionStyle(tv_v2, 2)
        }
        tv_v3.setOnClickListener {
            selectedOptionStyle(tv_v3, 3)
        }
        tv_v4.setOnClickListener {
            selectedOptionStyle(tv_v4, 4)
        }

        btn_submit.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList?.getOrNull(currentPosition - 1)
                if (question != null) {
                    if (selectedOption != question.correctAnswer) {
                        setColor(selectedOption, R.drawable.wrong_question_option)
                    } else {
                        score++
                    }
                    setColor(question.correctAnswer, R.drawable.correct_question_option)
                    if (currentPosition == questionList!!.size)
                        btn_submit.text = "FINISH"
                    else
                        btn_submit.text = "Go to Next"
                }
            } else {
                currentPosition++
                if (currentPosition <= questionList?.size ?: 0) {
                    setQuestion()
                } else {
                    val intent = Intent(this, ResultFruitsQuiz::class.java)
                    intent.putExtra(Constants.USERNAME, UserName.toString())
                    intent.putExtra(Constants.CORRECT_ANSWERS, score)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, questionList?.size ?: 0)
                    startActivity(intent)
                    finish()
                }
            }
            selectedOption = 0
        }
    }

    private fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> {
                tv_v1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                tv_v2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                tv_v3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                tv_v4.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    private fun setQuestion() {
        val question = questionList?.getOrNull(currentPosition - 1)
        question?.let {
            setOptionStyle()
            progressBar.progress = currentPosition
            progressBar.max = questionList?.size ?: 0
            tv_progress.text = "$currentPosition/${questionList?.size ?: 0}"
            tv_question.text = question.question
            iv_image.setImageResource(question.image)
            tv_v1.text = question.v1
            tv_v2.text = question.v2
            tv_v3.text = question.v3
            tv_v4.text = question.v4
        }
    }

    private fun setOptionStyle() {
        val optionList: List<TextView> = listOf(tv_v1, tv_v2, tv_v3, tv_v4)
        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
            op.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}
