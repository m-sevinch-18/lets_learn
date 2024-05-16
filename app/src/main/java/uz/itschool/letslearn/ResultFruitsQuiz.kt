package uz.itschool.letslearn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class ResultFruitsQuiz : AppCompatActivity() {
    private lateinit var Pname: TextView
    private lateinit var pscore: TextView
    private lateinit var pfinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_fruits_quiz)

        // Initialize views after setContentView
        Pname = findViewById(R.id.Pname)
        pscore = findViewById(R.id.pscore)
        pfinish = findViewById(R.id.pfinish)

        val username = intent.getStringExtra(Constants.USERNAME)
        Pname.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        pscore.text = " $correctAnswers out of $totalQuestions"

        pfinish.setOnClickListener {
            val intent = Intent(this, QuizScreen::class.java)
            startActivity(intent)
        }
    }
}
