package com.example.databindingfragment

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController


class SecondFragmentViewModel(): ViewModel() {
    private lateinit var questionList: MutableList<Question>

    lateinit var current: Question
//   private var _numberOfCorrectans = 0
    var numofWrongAns = 0
 var questionNumber = 0





    private  var _eventGame = MutableLiveData<Boolean>()

    val eventGame:LiveData<Boolean>
        get() = _eventGame



    private val _questions =  MutableLiveData<String>()
    val questions : LiveData<String>
        get() = _questions






    private val _numberOfCorrectans =  MutableLiveData<Int>()
    val numberOfCorrectans : LiveData<Int>
        get() = _numberOfCorrectans




    fun ques(){
        questionList = mutableListOf(
            Question(
                text = "What is  Jetpack?",
                ans =  true
            ),

            Question(text = "Base class for Layout?",
                ans = false
            ),

            Question(text = "Layout for complex Screens?",
                ans = true
            ),

            Question(text = "Pushing structured data into a Layout?",
                ans = false

            ),

            Question(text = "Inflate layout in fragments?",
                ans = true
            ),

            Question(text = "Build system for Android?",
                ans = false),

            Question(text = "Android vector format?",

                ans = true),

            Question(text = "Android Navigation Component?",
                ans = false
            ),

            Question(text = "Registers app with launcher?",
                ans = true),

            Question(text = "Mark a layout for Data Binding?",
                ans = false)

        )
    }


init {
    ques()
    _eventGame.value = false
    setQuestion()
    _numberOfCorrectans.value = 0

}
//    next





             fun setQuestion () {
            _questions.value   =  questionList[questionNumber].text

        }

     fun nextWord() {
        if (questionNumber < questionList.count().minus(1)){
            questionNumber++
            setQuestion()
        }else{
            _eventGame.value = true
        }




    }





    fun outcome(inputput:Boolean){
            if (questionList[questionNumber].ans == inputput){
                _numberOfCorrectans.value = (numberOfCorrectans.value)?.plus(1)
                println("right ${_numberOfCorrectans.value} ")

            }else{
              println("wrong")


            }

        }
    }



//    fun gameTrulyFinished(){
//        _eventGame.value = false
//    }


















