package com.example.databindingfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.databindingfragment.databinding.FragmentSecondFragmnetBinding
import kotlinx.android.synthetic.main.fragment_second_fragmnet.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragmnet : Fragment() {
    private  lateinit var  binding:FragmentSecondFragmnetBinding


    val questions: MutableList<Question> = mutableListOf(
        Question(text = "What is  Jetpack?",
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


    var questionNumber = 0

    lateinit var current: Question
    var numberOfCorrectans = 0
    var numofWrongAns = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate<FragmentSecondFragmnetBinding>(inflater, R.layout.fragment_second_fragmnet, container, false)
set()



//        TRUE BUTTON
        binding.trueButton.setOnClickListener {

            var correctAns =  questions[questionNumber].ans
        outcome(it, correctAns, true)

        }


        //FALSE BUTTON
        binding.falseButton.setOnClickListener {

            var correctAns =  questions[questionNumber].ans

                outcome(it, correctAns, false)
        }




        return binding.root
    }
//




//    METHODS
        fun set(){

    binding.questionText.text = questions[questionNumber].text
    binding.questionNum.text = "Question ${ questionNumber+1 } / 10"

        }


    fun outcome(it:View, correctAns:Boolean, inputput:Boolean){

        if (questionNumber   < questions.count() - 1 ){
            questionNumber++
            set()
            if (correctAns == inputput){

                numberOfCorrectans++

                println("right$numberOfCorrectans")

            }else{
                numofWrongAns++

                println(numofWrongAns)
            }

        }else {
            if (numberOfCorrectans > 5) {
                it.findNavController().navigate(SecondFragmnetDirections.actionSecondFragmnetToThird(numberOfCorrectans))
            } else {
                it.findNavController().navigate(SecondFragmnetDirections.actionSecondFragmnetToLoss(numberOfCorrectans))
            }
        }
    }


}

