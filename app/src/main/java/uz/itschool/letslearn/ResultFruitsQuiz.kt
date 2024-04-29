package uz.itschool.letslearn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class ResultFruitsQuiz : AppCompatActivity() {
    private var Pname = findViewById<TextView>(R.id.Pname)
    private var pscore = findViewById<TextView>(R.id.pscore)
    private var pfinish = findViewById<Button>(R.id.pfinish)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_fruits_quiz)

        val username = intent.getStringExtra(Constants.USERNAME)
        Pname.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        pscore.text = " $correctAnswers out of $totalQuestions"

        pfinish.setOnClickListener {
            val intent = Intent(this,QuizScreen::class.java)
            startActivity(intent)
        }


    }
}