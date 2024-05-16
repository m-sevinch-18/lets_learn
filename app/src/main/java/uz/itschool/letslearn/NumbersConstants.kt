package uz.itschool.letslearn
object NumbersConstants {
    const val p_name:String="name"
    const val score:String="score"
    const val ques_total: String = "totalquestions"

    fun getQuestions():MutableList<NumbersQuizQuestions>{

        var q:MutableList<NumbersQuizQuestions> = mutableListOf()

        q.add(
            NumbersQuizQuestions("Write the numbers",R.drawable.nine,
            R.drawable.two,R.drawable.seven,R.drawable.four,"nine","two","seven","four")
        )
        q.add(
            NumbersQuizQuestions("Write the numbers",R.drawable.eight,
                R.drawable.three,R.drawable.six,R.drawable.ten,"eight","three","six","ten")
        )

           return q
    }
}