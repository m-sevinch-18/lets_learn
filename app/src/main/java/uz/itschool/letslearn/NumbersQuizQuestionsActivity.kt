package uz.itschool.letslearn
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class NumbersQuizQuestionsActivity : AppCompatActivity() {
    private var buttonsubmit = findViewById<Button>(R.id.buttonsubmit)
    private var num_ans1 = findViewById<EditText>(R.id.num_ans1)
    private var num_ans2= findViewById<EditText>(R.id.num_ans2)
    private var num_ans3 = findViewById<EditText>(R.id.num_ans3)
    private var num_ans4 = findViewById<EditText>(R.id.num_ans4)


    private var num_v1 = findViewById<ImageView>(R.id.num_v1)
    private var num_v2 = findViewById<ImageView>(R.id.num_v2)
    private var num_v3 = findViewById<ImageView>(R.id.num_v3)
    private var num_v4= findViewById<ImageView>(R.id.num_v4)

    private var ques = findViewById<TextView>(R.id.ques)
    private var correctanswer = findViewById<ImageView>(R.id.correctanswer)


    private var Name:String?=null
    private var score:Int=0
    private  var index =0
    var numberQuestions : MutableList<NumbersQuizQuestions> ?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_quiz_questions)
        var variant: NumbersQuizQuestions = numberQuestions!!.get(index)
        Name=intent.getStringExtra(NumbersConstants.p_name)



        numberQuestions = NumbersConstants.getQuestions()
        createTest(index)

        buttonsubmit.setOnClickListener {
            if (num_ans1.text.toString() == variant.a1){
                correctanswer.visibility = View.VISIBLE
            }
            if (index < numberQuestions!!.size - 1) {
                index++
            }

            createTest(index)

        }

    }
    private fun createTest(i:Int){
        var variants: NumbersQuizQuestions = numberQuestions!!.get(index)
        ques.text = variants.question
        num_v1.setImageResource(variants.v1)
        num_v2.setImageResource(variants.v2)
        num_v3.setImageResource(variants.v3)
        num_v4.setImageResource(variants.v4)

        num_ans1.setText("")
        num_ans2.setText("")
        num_ans3.setText("")
        num_ans4.setText("")



    }
}