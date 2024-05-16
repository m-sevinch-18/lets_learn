package uz.itschool.letslearn

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton


class Animals : AppCompatActivity(), View.OnClickListener {
    private lateinit var rasmsher: ImageView
    private lateinit var rasmayiq: ImageView
    private lateinit var rasmilon: ImageView
    private lateinit var rasmmaymun: ImageView
    private lateinit var rasmfel: ImageView
    private lateinit var rasmzebra: ImageView
    private lateinit var rasmtimsoh: ImageView
    private lateinit var rasmtulki: ImageView
    private lateinit var rasmbugu: ImageView
    private lateinit var rasmjirafa: ImageView

    private lateinit var backa: MaterialButton
    private lateinit var nextA: MaterialButton
    private lateinit var prevA: MaterialButton
    private lateinit var voiceA: MaterialButton
    private lateinit var firstlion: ImageView

    private lateinit var engwordA: TextView
    private lateinit var uzwordA: TextView
    private lateinit var constraintlayoutA: ConstraintLayout
    private lateinit var linearlayoutanimals: LinearLayout

    private lateinit var mediaPlayer: MediaPlayer

    var animalslist = mutableListOf<Animalsobject>()
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        // Initialize views after setContentView
        rasmsher = findViewById(R.id.rasmsher)
        rasmayiq = findViewById(R.id.rasmayiq)
        rasmilon = findViewById(R.id.rasmilon)
        rasmmaymun = findViewById(R.id.rasmmaymun)
        rasmfel = findViewById(R.id.rasmfel)
        rasmzebra = findViewById(R.id.rasmzebra)
        rasmtimsoh = findViewById(R.id.rasmtimsoh)
        rasmtulki = findViewById(R.id.rasmtulki)
        rasmbugu = findViewById(R.id.rasmbugu)
        rasmjirafa = findViewById(R.id.rasmjirafa)

        backa = findViewById(R.id.backa)
        nextA = findViewById(R.id.nextA)
        prevA = findViewById(R.id.prevA)
        voiceA = findViewById(R.id.voiceA)
        firstlion = findViewById(R.id.firstlion)

        engwordA = findViewById(R.id.engwordA)
        uzwordA = findViewById(R.id.uzwordA)
        constraintlayoutA = findViewById(R.id.constraintlayoutA)
        linearlayoutanimals = findViewById(R.id.linearlayoutanimals)

        mediaPlayer = MediaPlayer.create(this, R.raw.apple)

        // Initialize animal list
        animalslist.add(Animalsobject("Lion", "Sher", R.drawable.lion, R.raw.lion))
        animalslist.add(Animalsobject("Bear", "Ayiq", R.drawable.bear, R.raw.bear))
        animalslist.add(Animalsobject("Snake", "Ilon", R.drawable.snake, R.raw.snake))
        animalslist.add(Animalsobject("Monkey", "Maymun", R.drawable.monkey, R.raw.monkey))
        animalslist.add(Animalsobject("Elephant", "Fil", R.drawable.elephant, R.raw.elephant))
        animalslist.add(Animalsobject("Zebra", "Zebra", R.drawable.zebra, R.raw.zebra))
        animalslist.add(Animalsobject("Crocodile", "Timsoh", R.drawable.crocodile, R.raw.crocodile))
        animalslist.add(Animalsobject("Fox", "Tulki", R.drawable.fox, R.raw.fox))
        animalslist.add(Animalsobject("Deer", "Bug'u", R.drawable.deer, R.raw.deer))
        animalslist.add(Animalsobject("Giraffe", "Jirafa", R.drawable.giraffe, R.raw.giraffe))

        // Set click listeners
        rasmsher.setOnClickListener(this)
        rasmayiq.setOnClickListener(this)
        rasmilon.setOnClickListener(this)
        rasmmaymun.setOnClickListener(this)
        rasmfel.setOnClickListener(this)
        rasmzebra.setOnClickListener(this)
        rasmtimsoh.setOnClickListener(this)
        rasmtulki.setOnClickListener(this)
        rasmbugu.setOnClickListener(this)
        rasmjirafa.setOnClickListener(this)

        backa.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        nextA.setOnClickListener {
            Next()
        }

        prevA.setOnClickListener {
            Prev()
        }

        voiceA.setOnClickListener {
            mediaPlayer.start()
        }
    }

    override fun onClick(view: View?) {
        val image = view as ImageView
        val tag = image.tag.toString().toInt()
        index = tag
        val a = animalslist[tag]
        firstlion.setImageResource(a.image)
        engwordA.text = a.engword
        uzwordA.text = a.uzword
        constraintlayoutA.visibility = View.VISIBLE
        linearlayoutanimals.visibility = View.GONE
        mediaPlayer = MediaPlayer.create(this, a.voice)
    }

    fun Prev() {
        if (index > 0) {
            index--
            val a = animalslist[index]
            firstlion.setImageResource(a.image)
            engwordA.text = a.engword
            uzwordA.text = a.uzword
            mediaPlayer = MediaPlayer.create(this, a.voice)
        }
    }

    fun Next() {
        if (index < animalslist.size - 1) {
            index++
            val a = animalslist[index]
            firstlion.setImageResource(a.image)
            engwordA.text = a.engword
            uzwordA.text = a.uzword
            mediaPlayer = MediaPlayer.create(this, a.voice)
        }
    }
}
