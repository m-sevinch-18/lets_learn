package uz.itschool.letslearn
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class QuizScreen : AppCompatActivity() {
    private lateinit var musicplay: Button
    private lateinit var volumeoff: Button
    private lateinit var quizback: Button
    private lateinit var Fruitsquiz: Button
    private lateinit var Animalsquiz: Button
    private lateinit var numbersquiz: Button

    private var volumeOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_screen)

        // Initialize views after setContentView
        musicplay = findViewById(R.id.musicplay)
        volumeoff = findViewById(R.id.volumeoff)
        quizback = findViewById(R.id.quizback)
        Fruitsquiz = findViewById(R.id.Fruitsquiz)
        Animalsquiz = findViewById(R.id.Animalsquiz)
        numbersquiz = findViewById(R.id.numbersquiz)

        // Start background music
        val mediaPlayer = MediaPlayer.create(this, R.raw.back_main_music)
        mediaPlayer.start()

        musicplay.setOnClickListener {
            mediaPlayer.stop()
            volumeoff.visibility = View.VISIBLE
            musicplay.visibility = View.GONE
        }

        quizback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Fruitsquiz.setOnClickListener {
            val intent = Intent(this, FruitsQuiz::class.java)
            startActivity(intent)
        }

        Animalsquiz.setOnClickListener {
            val intent = Intent(this, AnimalsQuiz::class.java)
            startActivity(intent)
        }

        numbersquiz.setOnClickListener {
            val intent = Intent(this, NumbersQuiz::class.java)
            startActivity(intent)
        }
    }
}
