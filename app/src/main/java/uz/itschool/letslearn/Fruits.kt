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


class Fruits : AppCompatActivity(), View.OnClickListener{

    var fruitslist = mutableListOf<FruitsName>()
    var index = 0
    lateinit var mediaPlayer: MediaPlayer

    private var rasmolma = findViewById<ImageView>(R.id.rasmolma)
    private var rasmbanan = findViewById<ImageView>(R.id.rasmbanan)
    private var rasmuzum = findViewById<ImageView>(R.id.rasmuzum)
    private var rasmanor= findViewById<ImageView>(R.id.rasmanor)
    private var rasmapelsin= findViewById<ImageView>(R.id.rasmapelsin)
    private var rasmlemon= findViewById<ImageView>(R.id.rasmlemon)
    private var rasmolcha= findViewById<ImageView>(R.id.rasmolcha)
    private var rasmnok= findViewById<ImageView>(R.id.rasmnok)
    private var rasmorik= findViewById<ImageView>(R.id.rasmorik)
    private var rasmqulupnay= findViewById<ImageView>(R.id.rasmqulupnay)

    private var back = findViewById<ImageView>(R.id.back)
    private var next = findViewById<ImageView>(R.id.next)
    private var prev = findViewById<ImageView>(R.id.prev)
    private var voice = findViewById<ImageView>(R.id.voice)
    private var apple = findViewById<ImageView>(R.id.apple)

    private var engword = findViewById<TextView>(R.id.engword)
    private var uzword = findViewById<TextView>(R.id.uzword)
    private var constraintlayout = findViewById<ConstraintLayout>(R.id.constraintlayout)
    private var linearlayoutfruits = findViewById<LinearLayout>(R.id.linearlayoutfruits)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)
        mediaPlayer = MediaPlayer.create(this, R.raw.apple)


        fruitslist.add(FruitsName("Apple","Olma", R.drawable.apple, R.raw.apple))
        fruitslist.add(FruitsName("Banana","Banan", R.drawable.banana,R.raw.banana))
        fruitslist.add(FruitsName("Grapes","Uzum", R.drawable.grapes,R.raw.grapes))
        fruitslist.add(FruitsName("Apricot","O'rik", R.drawable.apricot,R.raw.apricot))
        fruitslist.add(FruitsName("Cherry","Olcha", R.drawable.cherry,R.raw.cherry))
        fruitslist.add(FruitsName("Lemon","Limon", R.drawable.lemon,R.raw.lemon))
        fruitslist.add(FruitsName("Orange","Apelsin", R.drawable.orange,R.raw.orange))
        fruitslist.add(FruitsName("Pear","Nok", R.drawable.pear,R.raw.pear))
        fruitslist.add(FruitsName("Strawberry","Qulupnay", R.drawable.strawberry,R.raw.strawberry))
        fruitslist.add(FruitsName("Pomegranate","Anor", R.drawable.pomegranate,R.raw.pomegranate))



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
            val intent = Intent(this,MainActivity::class.java)
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
        var image = findViewById<ImageView>(view!!.id)
        var tag =image.tag.toString().toInt()
        index = tag
        var f = (fruitslist.get(tag))
        apple.setImageResource(f.image)
        engword.text = f.word1
        uzword.text = f.worduz
        constraintlayout.visibility = View.VISIBLE
        linearlayoutfruits.visibility = View.GONE
        mediaPlayer = MediaPlayer.create(this, f.voice)

    }
    fun Prev(){
        if(index>0){
            index--
            var f = (fruitslist.get(index))
            apple.setImageResource(f.image)
            engword.text = f.word1
            uzword.text = f.worduz
            mediaPlayer = MediaPlayer.create(this, f.voice)
        }}

    fun Next(){
        if(index<fruitslist.size-1){
            index++
            var f = (fruitslist.get(index))
            apple.setImageResource(f.image)
            engword.text = f.word1
            uzword.text = f.worduz
            mediaPlayer = MediaPlayer.create(this, f.voice)
        }
    }
}