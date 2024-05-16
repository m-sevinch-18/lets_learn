package uz.itschool.letslearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputLayout


class AnimalsQuiz : AppCompatActivity() {
    private lateinit var buttona: Button
    private lateinit var inputa: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz)

        // Initialize views after setContentView
        buttona = findViewById(R.id.buttona)
        inputa = findViewById(R.id.inputa)

        buttona.setOnClickListener {
            if (inputa.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, AnimalsQuizQuestions::class.java)
                intent.putExtra(Constants.UserName, inputa.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
