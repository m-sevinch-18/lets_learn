package uz.itschool.letslearn
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class NumbersQuizQuestionsActivity : AppCompatActivity() {
    private lateinit var buttonsubmit: Button
    private lateinit var num_ans1: EditText
    private lateinit var num_ans2: EditText
    private lateinit var num_ans3: EditText
    private lateinit var num_ans4: EditText

    private lateinit var num_v1: ImageView
    private lateinit var num_v2: ImageView
    private lateinit var num_v3: ImageView
    private lateinit var num_v4: ImageView

    private lateinit var ques: TextView
    private lateinit var correctanswer: ImageView

    private var Name: String? = null
    private var score: Int = 0
    private var index = 0
    private var numberQuestions: MutableList<NumbersQuizQuestions>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_quiz_questions)

        // Initialize views after setContentView
        buttonsubmit = findViewById(R.id.buttonsubmit)
        num_ans1 = findViewById(R.id.num_ans1)
        num_ans2 = findViewById(R.id.num_ans2)
        num_ans3 = findViewById(R.id.num_ans3)
        num_ans4 = findViewById(R.id.num_ans4)

        num_v1 = findViewById(R.id.num_v1)
        num_v2 = findViewById(R.id.num_v2)
        num_v3 = findViewById(R.id.num_v3)
        num_v4 = findViewById(R.id.num_v4)

        ques = findViewById(R.id.ques)
        correctanswer = findViewById(R.id.correctanswer)

        Name = intent.getStringExtra(NumbersConstants.p_name)

        numberQuestions = NumbersConstants.getQuestions()
        createTest(index)

        buttonsubmit.setOnClickListener {
            val variant: NumbersQuizQuestions = numberQuestions?.get(index) ?: return@setOnClickListener
            if (num_ans1.text.toString() == variant.a1) {
                correctanswer.visibility = View.VISIBLE
            }
            if (index < numberQuestions!!.size - 1) {
                index++
                createTest(index)
            }
        }
    }

    private fun createTest(i: Int) {
        val variants: NumbersQuizQuestions = numberQuestions?.get(i) ?: return
        ques.text = variants.question
        num_v1.setImageResource(variants.v1)
        num_v2.setImageResource(variants.v2)
        num_v3.setImageResource(variants.v3)
        num_v4.setImageResource(variants.v4)

        num_ans1.setText("")
        num_ans2.setText("")
        num_ans3.setText("")
        num_ans4.setText("")
    }
}
