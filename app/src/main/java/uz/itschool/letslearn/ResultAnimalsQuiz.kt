package uz.itschool.letslearn


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class ResultAnimalsQuiz : AppCompatActivity() {
    private lateinit var Aname: TextView
    private lateinit var Ascore: TextView
    private lateinit var Afinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_animals_quiz)

        // Initialize views after setContentView
        Aname = findViewById(R.id.Aname)
        Ascore = findViewById(R.id.Ascore)
        Afinish = findViewById(R.id.Afinish)

        val username = intent.getStringExtra(Constants.UserName)
        Aname.text = username
        val totalQuestions = intent.getIntExtra(Constants.TotalQues, 0)
        val correctAnswers = intent.getIntExtra(Constants.Score, 0)
        Ascore.text = " $correctAnswers out of $totalQuestions"

        Afinish.setOnClickListener {
            val intent = Intent(this, QuizScreen::class.java)
            startActivity(intent)
        }
    }
}
