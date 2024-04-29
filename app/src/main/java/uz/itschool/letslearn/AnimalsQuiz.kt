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
    private var buttona = findViewById<Button>(R.id.buttona)
    private var inputa = findViewById<EditText>(R.id.inputa)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz)

        buttona.setOnClickListener {
            if (inputa.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,AnimalsQuizQuestions::class.java)
                intent.putExtra(Constants.UserName,inputa.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}