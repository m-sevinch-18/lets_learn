package uz.itschool.letslearn
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class FruitsQuizQuestionsActivity : AppCompatActivity(){

    private var btn_submit = findViewById<Button>(R.id.buttonsubmit)
    private var tv_v1 = findViewById<TextView>(R.id.tv_v1)
    private var tv_v2= findViewById<TextView>(R.id.tv_v2)
    private var tv_v3 = findViewById<TextView>(R.id.tv_v3)
    private var tv_v4 = findViewById<TextView>(R.id.tv_v4)


    private var iv_image = findViewById<ImageView>(R.id.iv_image)
    private var tv_question = findViewById<TextView>(R.id.tv_question)
    private var tv_progress = findViewById<TextView>(R.id.tv_progress)
    private var progressBar = findViewById<ProgressBar>(R.id.progressBar)

    private var UserName:String?=null
    private var currentPosition:Int=1
    private var questionList:MutableList<FruitsQuestions> ? = null
    private var selecedOption:Int=0
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_quiz_questions)

        UserName = intent.getStringExtra(Constants.USERNAME)
        questionList = Constants.getQuestions()


        setQuestion()

        tv_v1.setOnClickListener{

            selectedOptionStyle(tv_v1,1)
        }
        tv_v2.setOnClickListener{

            selectedOptionStyle(tv_v2,2)
        }
        tv_v3.setOnClickListener{

            selectedOptionStyle(tv_v3,3)
        }
        tv_v4.setOnClickListener{

            selectedOptionStyle(tv_v4,4)
        }

        btn_submit.setOnClickListener {
            if(selecedOption!=0)
            {
                val question=questionList!![currentPosition-1]
                if(selecedOption!=question.correctAnswer)
                {
                    setColor(selecedOption,R.drawable.wrong_question_option)
                }else{
                    score++
                }
                setColor(question.correctAnswer,R.drawable.correct_question_option)
                if(currentPosition==questionList!!.size)
                    btn_submit.text="FINISH"
                else
                    btn_submit.text="Go to Next"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent= Intent(this,ResultFruitsQuiz::class.java)
                        intent.putExtra(Constants.USERNAME,UserName.toString())
                        intent.putExtra(Constants.CORRECT_ANSWERS,score)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,questionList!!.size)

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selecedOption=0
        }

    }

    fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                tv_v1.background= ContextCompat.getDrawable(this,color)
            }
            2->{
                tv_v2.background= ContextCompat.getDrawable(this,color)
            }
            3->{
                tv_v3.background= ContextCompat.getDrawable(this,color)
            }
            4->{
                tv_v4.background= ContextCompat.getDrawable(this,color)
            }
        }
    }


    fun setQuestion(){

        val question = questionList!![currentPosition-1]
        setOptionStyle()
        progressBar.progress=currentPosition
        progressBar.max=questionList!!.size
        tv_progress.text="${currentPosition}"+"/"+"${questionList!!.size}"
        tv_question.text=question.question
        iv_image.setImageResource(question.image)
        tv_v1.text=question.v1
        tv_v2.text=question.v2
        tv_v3.text=question.v3
        tv_v4.text=question.v4

    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,tv_v1)
        optionList.add(1,tv_v2)
        optionList.add(2,tv_v3)
        optionList.add(3,tv_v4)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background= ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt:Int){

        setOptionStyle()
        selecedOption=opt
        view.background= ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }


    }