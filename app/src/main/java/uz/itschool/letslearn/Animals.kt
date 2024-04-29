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


class Animals : AppCompatActivity(), View.OnClickListener {
    var animalslist = mutableListOf<Animalsobject>()
    var index = 0
    private var rasmsher = findViewById<ImageView>(R.id.rasmsher)
    private var rasmayiq = findViewById<ImageView>(R.id.rasmayiq)
    private var rasmilon = findViewById<ImageView>(R.id.rasmilon)
    private var rasmmaymun= findViewById<ImageView>(R.id.rasmmaymun)
    private var rasmfel = findViewById<ImageView>(R.id.rasmfel)
    private var rasmzebra = findViewById<ImageView>(R.id.rasmzebra)
    private var rasmtimsoh= findViewById<ImageView>(R.id.rasmtimsoh)
    private var rasmtulki= findViewById<ImageView>(R.id.rasmtulki)
    private var rasmbugu= findViewById<ImageView>(R.id.rasmbugu)
    private var rasmjirafa= findViewById<ImageView>(R.id.rasmjirafa)

    private var backa = findViewById<ImageView>(R.id.backa)
    private var nextA = findViewById<ImageView>(R.id.nextA)
    private var prevA = findViewById<ImageView>(R.id.prevA)
    private var voiceA = findViewById<ImageView>(R.id.voiceA)
    private var firstlion = findViewById<ImageView>(R.id.firstlion)

    private var engwordA = findViewById<TextView>(R.id.engwordA)
    private var uzwordA = findViewById<TextView>(R.id.uzwordA)
    private var constraintlayoutA = findViewById<ConstraintLayout>(R.id.constraintlayoutA)
    private var linearlayoutanimals = findViewById<LinearLayout>(R.id.linearlayoutanimals)


    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
        mediaPlayer = MediaPlayer.create(this, R.raw.apple)

        animalslist.add(Animalsobject("Lion","Sher",R.drawable.lion, R.raw.lion))
        animalslist.add(Animalsobject("Bear","Ayiq",R.drawable.bear, R.raw.bear))
        animalslist.add(Animalsobject("Snake","Ilon",R.drawable.snake, R.raw.snake))
        animalslist.add(Animalsobject("Monkey","Maymun",R.drawable.monkey, R.raw.monkey))
        animalslist.add(Animalsobject("Elephant","Fil",R.drawable.elephant, R.raw.elephant))
        animalslist.add(Animalsobject("Zebra","Zebra",R.drawable.zebra, R.raw.zebra))
        animalslist.add(Animalsobject("Crocodile","Timsoh",R.drawable.crocodile, R.raw.crocodile))
        animalslist.add(Animalsobject("Fox","Tulki",R.drawable.fox, R.raw.fox))
        animalslist.add(Animalsobject("Deer","Bug'u",R.drawable.deer, R.raw.deer))
        animalslist.add(Animalsobject("Giraffe","Jirafa",R.drawable.giraffe, R.raw.giraffe))



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
            var intent = Intent(this,MainActivity::class.java)
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
        var image = findViewById<ImageView>(view!!.id)
        var tag =image.tag.toString().toInt()
        index = tag
        var a = (animalslist.get(tag))
        firstlion.setImageResource(a.image)
        engwordA.text = a.engword
        uzwordA.text = a.uzword
        constraintlayoutA.visibility = View.VISIBLE
        linearlayoutanimals.visibility = View.GONE
        mediaPlayer = MediaPlayer.create(this, a.voice)

    }
    fun Prev(){
        if(index>0){
            index--
            var a = (animalslist.get(index))
            firstlion.setImageResource(a.image)
            engwordA.text = a.engword
            uzwordA.text = a.uzword
            mediaPlayer = MediaPlayer.create(this, a.voice)

        }}

    fun Next(){
        if(index<animalslist.size-1){
            index++
            var a = (animalslist.get(index))
            firstlion.setImageResource(a.image)
            engwordA.text = a.engword
            uzwordA.text = a.uzword
            mediaPlayer = MediaPlayer.create(this, a.voice)
        }
    }
}