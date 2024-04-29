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
    private var musicplay = findViewById<Button>(R.id.musicplay)
    private var volumeoff = findViewById<Button>(R.id.volumeoff)
    private var quizback = findViewById<Button>(R.id.quizback)
    private var Fruitsquiz = findViewById<Button>(R.id.Fruitsquiz)
    private var Animalsquiz = findViewById<Button>(R.id.Animalsquiz)
    private var numbersquiz = findViewById<Button>(R.id.numbersquiz)


    var volumeOn = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_screen)
       var  mediaPlayer = MediaPlayer.create(this, R.raw.back_main_music)
        mediaPlayer.start()
        musicplay.setOnClickListener {
            mediaPlayer.stop()
            volumeoff.visibility=View.VISIBLE
            musicplay.visibility =View.GONE


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