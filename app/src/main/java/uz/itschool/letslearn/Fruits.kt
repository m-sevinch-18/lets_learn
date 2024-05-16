package uz.itschool.letslearn
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton


class Fruits : AppCompatActivity(), View.OnClickListener{

    var fruitslist = mutableListOf<FruitsName>()
    var index = 0
    lateinit var mediaPlayer: MediaPlayer

    private lateinit var rasmolma: ImageView
    private lateinit var rasmbanan: ImageView
    private lateinit var rasmuzum: ImageView
    private lateinit var rasmanor: ImageView
    private lateinit var rasmapelsin: ImageView
    private lateinit var rasmlemon: ImageView
    private lateinit var rasmolcha: ImageView
    private lateinit var rasmnok: ImageView
    private lateinit var rasmorik: ImageView
    private lateinit var rasmqulupnay: ImageView

    private lateinit var back: MaterialButton
    private lateinit var next: MaterialButton
    private lateinit var prev: MaterialButton
    private lateinit var voice: MaterialButton
    private lateinit var apple: ImageView

    private lateinit var engword: TextView
    private lateinit var uzword: TextView
    private lateinit var constraintlayout: ConstraintLayout
    private lateinit var linearlayoutfruits: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)
        mediaPlayer = MediaPlayer.create(this, R.raw.apple)

        // Initialize views after setContentView
        rasmolma = findViewById(R.id.rasmolma)
        rasmbanan = findViewById(R.id.rasmbanan)
        rasmuzum = findViewById(R.id.rasmuzum)
        rasmanor = findViewById(R.id.rasmanor)
        rasmapelsin = findViewById(R.id.rasmapelsin)
        rasmlemon = findViewById(R.id.rasmlemon)
        rasmolcha = findViewById(R.id.rasmolcha)
        rasmnok = findViewById(R.id.rasmnok)
        rasmorik = findViewById(R.id.rasmorik)
        rasmqulupnay = findViewById(R.id.rasmqulupnay)
        back = findViewById(R.id.back)
        next = findViewById(R.id.next)
        prev = findViewById(R.id.prev)
        voice = findViewById(R.id.voice)
        apple = findViewById(R.id.apple)
        engword = findViewById(R.id.engword)
        uzword = findViewById(R.id.uzword)
        constraintlayout = findViewById(R.id.constraintlayout)
        linearlayoutfruits = findViewById(R.id.linearlayoutfruits)

        fruitslist.addAll(
            listOf(
                FruitsName("Apple", "Olma", R.drawable.apple, R.raw.apple),
                FruitsName("Banana", "Banan", R.drawable.banana, R.raw.banana),
                FruitsName("Grapes", "Uzum", R.drawable.grapes, R.raw.grapes),
                FruitsName("Apricot", "O'rik", R.drawable.apricot, R.raw.apricot),
                FruitsName("Cherry", "Olcha", R.drawable.cherry, R.raw.cherry),
                FruitsName("Lemon", "Limon", R.drawable.lemon, R.raw.lemon),
                FruitsName("Orange", "Apelsin", R.drawable.orange, R.raw.orange),
                FruitsName("Pear", "Nok", R.drawable.pear, R.raw.pear),
                FruitsName("Strawberry", "Qulupnay", R.drawable.strawberry, R.raw.strawberry),
                FruitsName("Pomegranate", "Anor", R.drawable.pomegranate, R.raw.pomegranate)
            )
        )

        // Set click listeners
        rasmolma.setOnClickListener(this)
        rasmbanan.setOnClickListener(this)
        rasmuzum.setOnClickListener(this)
        rasmanor.setOnClickListener(this)
        rasmapelsin.setOnClickListener(this)
        rasmlemon.setOnClickListener(this)
        rasmnok.setOnClickListener(this)
        rasmolcha.setOnClickListener(this)
        rasmorik.setOnClickListener(this)
        rasmqulupnay.setOnClickListener(this)

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        next.setOnClickListener {
            Next()
        }
        prev.setOnClickListener {
            Prev()
        }
        voice.setOnClickListener {
            mediaPlayer.start()
        }
    }

    override fun onClick(view: View?) {
        view?.let {
            var image = findViewById<ImageView>(it.id)
            var tag = image.tag.toString().toInt()
            index = tag
            var f = fruitslist[tag]
            apple.setImageResource(f.image)
            engword.text = f.word1
            uzword.text = f.worduz
            constraintlayout.visibility = View.VISIBLE
            linearlayoutfruits.visibility = View.GONE
            mediaPlayer = MediaPlayer.create(this, f.voice)
        }
    }

    fun Prev() {
        if (index > 0) {
            index--
            var f = fruitslist[index]
            apple.setImageResource(f.image)
            engword.text = f.word1
            uzword.text = f.worduz
            mediaPlayer = MediaPlayer.create(this, f.voice)
        }
    }

    fun Next() {
        if (index < fruitslist.size - 1) {
            index++
            var f = fruitslist[index]
            apple.setImageResource(f.image)
            engword.text = f.word1
            uzword.text = f.worduz
            mediaPlayer = MediaPlayer.create(this, f.voice)
        }
    }
}
