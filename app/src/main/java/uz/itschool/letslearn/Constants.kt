package uz.itschool.letslearn
object Constants{
    const val USERNAME: String = "username"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val TOTAL_QUESTIONS: String = "total_question"

    const val UserName:String = "Username"
    const val Score:String = "score"
    const val TotalQues:String = "totalquestion"

    fun getQuestions(): MutableList<FruitsQuestions>{
        val question_list: MutableList<FruitsQuestions> = mutableListOf()
        question_list.add(FruitsQuestions(
            1,
            "What is this?",
            R.drawable.cherry,
            "Apple",
            "Cherry",
            "Apricot",
            "Pomegranate",
            2
        ))
        question_list.add(FruitsQuestions(
            2,
            "What is this?",
            R.drawable.strawberry,
            "Pear",
            "Grapes",
            "Banana",
            "Strawberry",
            4
        ))
        question_list.add(FruitsQuestions(
            3,
            "What is this?",
            R.drawable.lemon,
            "Lemon",
            "Orange",
            "Apricot",
            "Apple",
            1
        ))
        question_list.add(FruitsQuestions(
            4,
            "What is this?",
            R.drawable.pomegranate,
            "Banana",
            "Orange",
            "Pomegranate",
            "Apple",
            3
        ))
        question_list.add(FruitsQuestions(
            5,
            "What is this?",
            R.drawable.pear,
            "Lemon",
            "Apricot",
            "Pear",
            "Orange",
            3
        ))
        question_list.add(FruitsQuestions(
            6,
            "What is this?",
            R.drawable.apple,
            "Lemon",
            "Pomegranate",
            "Apricot",
            "Apple",
            4
        ))
        question_list.add(FruitsQuestions(
            7,
            "What is this?",
            R.drawable.banana,
            "Lemon",
            "Banana",
            "Orange",
            "Apple",
            2
        ))
        question_list.add(FruitsQuestions(
            8,
            "What is this?",
            R.drawable.grapes,
            "Apricot",
            "Orange",
            "Grapes",
            "Apple",
            3
        ))
        question_list.add(FruitsQuestions(
            9,
            "What is this?",
            R.drawable.apricot,
            "Lemon",
            "Orange",
            "Apricot",
            "Apple",
            3
        ))
        question_list.add(FruitsQuestions(
            10,
            "What is this?",
            R.drawable.orange,
            "Pear",
            "Orange",
            "Apricot",
            "Pomegranate",
            2
        ))
        return question_list

    }

}