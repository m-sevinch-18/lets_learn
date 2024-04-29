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


class Numbers : AppCompatActivity(), View.OnClickListener {
    private var raqam1 = findViewById<ImageView>(R.id.raqam1)
    private var raqam2 = findViewById<ImageView>(R.id.raqam2)
    private var raqam3 = findViewById<ImageView>(R.id.raqam3)
    private var raqam4= findViewById<ImageView>(R.id.raqam4)
    private var raqam5 = findViewById<ImageView>(R.id.raqam5)
    private var raqam6 = findViewById<ImageView>(R.id.raqam6)
    private var raqam7= findViewById<ImageView>(R.id.raqam7)
    private var raqam8= findViewById<ImageView>(R.id.raqam8)
    private var raqam9= findViewById<ImageView>(R.id.raqam9)
    private var raqam10= findViewById<ImageView>(R.id.raqam10)

    private var backn = findViewById<ImageView>(R.id.backn)
    private var nextn = findViewById<ImageView>(R.id.nextn)
    private var prevn = findViewById<ImageView>(R.id.prevn)
    private var voicen = findViewById<ImageView>(R.id.voicen)
    private var firstnumber = findViewById<ImageView>(R.id.firstnumber)

    private var engwordN = findViewById<TextView>(R.id.engwordN)
    private var uzwordN = findViewById<TextView>(R.id.uzwordN)
    private var constraintlayoutN = findViewById<ConstraintLayout>(R.id.constraintlayoutN)
    private var linearlayoutnumbers = findViewById<LinearLayout>(R.id.linearlayoutfruits)

    var numberslist = mutableListOf<Numbertrans>()
    var index = 0
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)
        mediaPlayer = MediaPlayer.create(this, R.raw.number1)


        numberslist.add(Numbertrans("One", "Bir", R.drawable.one, R.raw.number1))
        numberslist.add(Numbertrans("Two", "Ikki", R.drawable.two, R.raw.number2))
        numberslist.add(Numbertrans("Three", "Uch", R.drawable.three, R.raw.number3))
        numberslist.add(Numbertrans("Four", "To'rt", R.drawable.four, R.raw.number4))
        numberslist.add(Numbertrans("Five", "Besh", R.drawable.five, R.raw.number5))
        numberslist.add(Numbertrans("Six", "Olti", R.drawable.siz, R.raw.number6))
        numberslist.add(Numbertrans("Seven", "Yetti", R.drawable.seven, R.raw.number7))
        numberslist.add(Numbertrans("Eight", "Sakkiz", R.drawable.eight, R.raw.number8))
        numberslist.add(Numbertrans("Nine", "To'qqiz", R.drawable.nine, R.raw.number9))
        numberslist.add(Numbertrans("Ten", "O'n", R.drawable.ten, R.raw.number10))


        raqam1.setOnClickListener(this)
        raqam2.setOnClickListener(this)
        raqam3.setOnClickListener(this)
        raqam4.setOnClickListener(this)
        raqam5.setOnClickListener(this)
        raqam6.setOnClickListener(this)
        raqam7.setOnClickListener(this)
        raqam8.setOnClickListener(this)
        raqam9.setOnClickListener(this)
        raqam10.setOnClickListener(this)

        backn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        nextn.setOnClickListener {
            Next()
        }
        prevn.setOnClickListener {
            Prev()
        }
        voicen.setOnClickListener {
            mediaPlayer.start()
        }
    }

    override fun onClick(view: View?) {

        var image = findViewById<ImageView>(view!!.id)
        var tag = image.tag.toString().toInt()
        index = tag
        var n = (numberslist.get(tag))
        firstnumber.setImageResource(n.image)
        engwordN.text = n.wordeng
        uzwordN.text = n.worduz
        constraintlayoutN.visibility = View.VISIBLE
        linearlayoutnumbers.visibility = View.GONE
        mediaPlayer = MediaPlayer.create(this, n.voice)
    }

    fun Prev() {
        if (index > 0) {
            index--
            var n = (numberslist.get(index))
            firstnumber.setImageResource(n.image)
            engwordN.text = n.wordeng
            uzwordN.text = n.worduz
            mediaPlayer = MediaPlayer.create(this, n.voice)

        }
    }

    fun Next() {
        if (index < numberslist.size - 1) {
            index++
            var n = (numberslist.get(index))
            firstnumber.setImageResource(n.image)
            engwordN.text = n.wordeng
            uzwordN.text = n.worduz
            mediaPlayer = MediaPlayer.create(this, n.voice)

        }
    }
}