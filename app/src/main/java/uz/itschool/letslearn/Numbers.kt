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


class Numbers : AppCompatActivity(), View.OnClickListener {
    private lateinit var raqam1: ImageView
    private lateinit var raqam2: ImageView
    private lateinit var raqam3: ImageView
    private lateinit var raqam4: ImageView
    private lateinit var raqam5: ImageView
    private lateinit var raqam6: ImageView
    private lateinit var raqam7: ImageView
    private lateinit var raqam8: ImageView
    private lateinit var raqam9: ImageView
    private lateinit var raqam10: ImageView

    private lateinit var backn: MaterialButton
    private lateinit var nextn: MaterialButton
    private lateinit var prevn: MaterialButton
    private lateinit var voicen: MaterialButton
    private lateinit var firstnumber: ImageView

    private lateinit var engwordN: TextView
    private lateinit var uzwordN: TextView
    private lateinit var constraintlayoutN: ConstraintLayout
    private lateinit var linearlayoutnumbers: LinearLayout

    private lateinit var mediaPlayer: MediaPlayer
    private var numberslist = mutableListOf<Numbertrans>()
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        // Initialize views after setContentView
        raqam1 = findViewById(R.id.raqam1)
        raqam2 = findViewById(R.id.raqam2)
        raqam3 = findViewById(R.id.raqam3)
        raqam4 = findViewById(R.id.raqam4)
        raqam5 = findViewById(R.id.raqam5)
        raqam6 = findViewById(R.id.raqam6)
        raqam7 = findViewById(R.id.raqam7)
        raqam8 = findViewById(R.id.raqam8)
        raqam9 = findViewById(R.id.raqam9)
        raqam10 = findViewById(R.id.raqam10)

        backn = findViewById(R.id.backn)
        nextn = findViewById(R.id.nextn)
        prevn = findViewById(R.id.prevn)
        voicen = findViewById(R.id.voicen)
        firstnumber = findViewById(R.id.firstnumber)

        engwordN = findViewById(R.id.engwordN)
        uzwordN = findViewById(R.id.uzwordN)
        constraintlayoutN = findViewById(R.id.constraintlayoutN)
        linearlayoutnumbers = findViewById(R.id.linearlayoutnumbers)

        mediaPlayer = MediaPlayer.create(this, R.raw.number1)

        numberslist.add(Numbertrans("One", "Bir", R.drawable.one, R.raw.number1))
        numberslist.add(Numbertrans("Two", "Ikki", R.drawable.two, R.raw.number2))
        numberslist.add(Numbertrans("Three", "Uch", R.drawable.three, R.raw.number3))
        numberslist.add(Numbertrans("Four", "To'rt", R.drawable.four, R.raw.number4))
        numberslist.add(Numbertrans("Five", "Besh", R.drawable.five, R.raw.number5))
        numberslist.add(Numbertrans("Six", "Olti", R.drawable.six, R.raw.number6))
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
        var image = view as ImageView
        var tag = image.tag.toString().toInt()
        index = tag
        var n = (numberslist[tag])
        firstnumber.setImageResource(n.image)
        engwordN.text = n.wordeng
        uzwordN.text = n.worduz
        constraintlayoutN.visibility = View.VISIBLE
        linearlayoutnumbers.visibility = View.GONE
        mediaPlayer = MediaPlayer.create(this, n.voice)
    }

    private fun Prev() {
        if (index > 0) {
            index--
            var n = (numberslist[index])
            firstnumber.setImageResource(n.image)
            engwordN.text = n.wordeng
            uzwordN.text = n.worduz
            mediaPlayer = MediaPlayer.create(this, n.voice)
        }
    }

    private fun Next() {
        if (index < numberslist.size - 1) {
            index++
            var n = (numberslist[index])
            firstnumber.setImageResource(n.image)
            engwordN.text = n.wordeng
            uzwordN.text = n.worduz
            mediaPlayer = MediaPlayer.create(this, n.voice)
        }
    }
}
