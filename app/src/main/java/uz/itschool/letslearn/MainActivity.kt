package uz.itschool.letslearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private var fruitscardview = findViewById<CardView>(R.id.fruitscardview)
    private var numberscarview = findViewById<CardView>(R.id.numberscarview)
    private var animalscardview = findViewById<CardView>(R.id.animalscardview)
    private var quizcardview = findViewById<CardView>(R.id.quizcardview)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}

            fruitscardview.setOnClickListener {
                val intent = Intent(this, Fruits::class.java)
                startActivity(intent)
            }

            numberscarview.setOnClickListener{
                val intent = Intent(this, Numbers::class.java)
                startActivity(intent)
            }

            animalscardview.setOnClickListener{
                val intent = Intent(this, Animals::class.java)
                startActivity(intent)
            }

            quizcardview.setOnClickListener {
                val intent = Intent(this,QuizScreen::class.java)
                startActivity(intent)
            }
        }

    }
