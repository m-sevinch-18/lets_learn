package uz.itschool.letslearn
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


class AnimalsQuizQuestions : AppCompatActivity(), View.OnClickListener{

    private var an_v1 = findViewById<ImageView>(R.id.an_v1)
    private var an_v2 = findViewById<ImageView>(R.id.an_v2)
    private var an_v3 = findViewById<ImageView>(R.id.an_v3)
    private var an_v4 = findViewById<ImageView>(R.id.an_v4)

    private var an_question = findViewById<TextView>(R.id.an_question)
    private var an_mainword = findViewById<TextView>(R.id.an_mainword)
    private var an_submit = findViewById<TextView>(R.id.an_submit)
    private var an_progress = findViewById<TextView>(R.id.an_progress)
    private var an_progressBar = findViewById<ProgressBar>(R.id.an_progressBar)




    var index =0
    var picturetests = mutableListOf<AnimalsQuestions>()
   var  SelectedOptionPosition=0
    var score = 0
    var username: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz_questions)


        username = intent.getStringExtra(Constants.UserName)


        picturetests.add(AnimalsQuestions("Choose the animal","Snake",R.drawable.lion,R.drawable.fox,R.drawable.snake,R.drawable.bear,3))
        picturetests.add(AnimalsQuestions("Choose the animal","Elephant",R.drawable.elephant,R.drawable.zebra,R.drawable.snake,R.drawable.monkey,1))
        picturetests.add(AnimalsQuestions("Choose the animal","Crocodile",R.drawable.giraffe,R.drawable.crocodile,R.drawable.deer,R.drawable.fox,2))
        picturetests.add(AnimalsQuestions("Choose the animal","Bear",R.drawable.monkey,R.drawable.elephant,R.drawable.lion,R.drawable.bear,4))
        picturetests.add(AnimalsQuestions("Choose the animal","Deer",R.drawable.fox,R.drawable.snake,R.drawable.zebra,R.drawable.deer,4))
        picturetests.add(AnimalsQuestions("Choose the animal","Monkey",R.drawable.monkey,R.drawable.elephant,R.drawable.giraffe,R.drawable.snake,1))
        picturetests.add(AnimalsQuestions("Choose the animal","Fox",R.drawable.lion,R.drawable.fox,R.drawable.zebra,R.drawable.bear,2))



        an_v1.setOnClickListener(this)
        an_v2.setOnClickListener(this)
        an_v3.setOnClickListener(this)
        an_v4.setOnClickListener(this)

        createTest(index)
        an_submit.setOnClickListener {

            if (SelectedOptionPosition != 0 ) {
                val question = picturetests.get(index)
                if (question.correctAnswer != SelectedOptionPosition) {
                    AnswerView(SelectedOptionPosition, R.drawable.wronganswer)
                } else {
                    score++
                    AnswerView(SelectedOptionPosition, R.drawable.correctanswer)
                }


                if (index == picturetests.size) {
                    an_submit.text = "FINISH"
                } else {
                    an_submit.text = "Go to next"
                }
                index++
            } else {
                when {
                    index <= picturetests.size-1 -> {
                        createTest(index)
                    }
                    else -> {
                        var intent = Intent(this, ResultAnimalsQuiz::class.java)
                        intent.putExtra(Constants.UserName, username.toString())
                        intent.putExtra(Constants.Score, score)
                        intent.putExtra(Constants.TotalQues, picturetests.size)

                        startActivity(intent)
                        finish()
                    }
                }
            }

            SelectedOptionPosition=0

        }
    }

    private fun createTest(index:Int){
        var test: AnimalsQuestions = picturetests[index]
        an_question.text = test.question
        an_progressBar.progress=index+1
        an_progressBar.max=picturetests.size
        an_progress.text="${index+1}"+"/"+"${picturetests.size}"
        an_mainword.text = test.mainword
        an_v1.setImageResource(test.v1)
        an_v2.setImageResource(test.v2)
        an_v3.setImageResource(test.v3)
        an_v4.setImageResource(test.v4)

    }



    private fun AnswerView(answer:Int, drawableView:Int){
        when(answer){
            1 -> {
                an_v1.setImageResource(drawableView)
            }
            2 -> {
                an_v2.setImageResource(drawableView)
            }
            3 -> {
                an_v3.setImageResource(drawableView)
            }
            4 -> {
                an_v4.setImageResource(drawableView)
            }
        }

    }

    fun selectedOptionStyle(image:ImageView,opt:Int) {
        SelectedOptionPosition = opt
        image.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

        override fun onClick(p0: View?) {
//            val images = findViewById<ImageView>(p0!!.id)
//            index = images.tag.toString().toInt()
//            createTest(index)

            when(p0?.id){
                R.id.an_v1 ->{
                    selectedOptionStyle(an_v1,1)
                }
                R.id.an_v2 ->{
                    selectedOptionStyle(an_v2,2)
                }
                R.id.an_v3 ->{
                    selectedOptionStyle(an_v3,3)
                }
                R.id.an_v4 ->{
                    selectedOptionStyle(an_v4,4)
                }


            }

}}