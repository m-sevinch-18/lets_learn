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
    private lateinit var fruitscardview: CardView
    private lateinit var numberscarview: CardView
    private lateinit var animalscardview: CardView
    private lateinit var quizcardview: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views after setContentView
        fruitscardview = findViewById(R.id.fruitscardview)
        numberscarview = findViewById(R.id.numberscarview)
        animalscardview = findViewById(R.id.animalscardview)
        quizcardview = findViewById(R.id.quizcardview)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listener for all card views
        fruitscardview.setOnClickListener {
            navigateToActivity(Fruits::class.java)
        }

        numberscarview.setOnClickListener {
            navigateToActivity(Numbers::class.java)
        }

        animalscardview.setOnClickListener {
            navigateToActivity(Animals::class.java)
        }

        quizcardview.setOnClickListener {
            navigateToActivity(QuizScreen::class.java)
        }
    }

    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
