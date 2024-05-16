package uz.itschool.letslearn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class NumbersQuiz : AppCompatActivity() {
    private lateinit var buttonN: Button
    private lateinit var inputN: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_quiz)

        // Initialize views after setContentView
        buttonN = findViewById(R.id.buttonN)
        inputN = findViewById(R.id.inputN)

        // Set click listener for the button
        buttonN.setOnClickListener {
            if (inputN.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, NumbersQuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME, inputN.text.toString())
                startActivity(intent)
            }
        }
    }
}
