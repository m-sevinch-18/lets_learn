package uz.itschool.letslearn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class FruitsQuiz : AppCompatActivity() {
    private lateinit var buttonf: Button
    private lateinit var inputf: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_quiz)

        // Initialize views after setContentView
        buttonf = findViewById(R.id.buttonf)
        inputf = findViewById(R.id.inputf)

        buttonf.setOnClickListener {
            if (inputf.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, FruitsQuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME, inputf.text.toString())
                startActivity(intent)
            }
        }
    }
}
