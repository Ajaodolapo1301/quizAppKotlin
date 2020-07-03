package com.example.databindingfragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.databindingfragment.databinding.FragmentSecondFragmnetBinding



class SecondFragmnet : Fragment() {
    private  lateinit var  binding:FragmentSecondFragmnetBinding

    private lateinit var viewModel: SecondFragmentViewModel








    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate<FragmentSecondFragmnetBinding>(inflater, R.layout.fragment_second_fragmnet, container, false)



        viewModel = ViewModelProviders.of(this).get(SecondFragmentViewModel::class.java)


        viewModel.questions.observe(viewLifecycleOwner, Observer { newQues->
    binding.questionNum.text = "Question ${viewModel.questionNumber + 1} / 10"
            binding.questionText.text = newQues.toString()
        })



        viewModel.eventGame.observe(viewLifecycleOwner, Observer {hasfinished->
            if (hasfinished){
                println(hasfinished)
                gameFinished()
//                viewModel.gameTrulyFinished()
            }



        })





//        TRUE BUTTON
        binding.trueButton.setOnClickListener {
            viewModel.nextWord()
      viewModel.outcome( true)

        }


        //FALSE BUTTON
        binding.falseButton.setOnClickListener {
                viewModel.nextWord()
            viewModel.outcome( false)
        }













        return binding.root
    }




    private fun updateWordText() {

        binding.questionText.text = viewModel.questions.value
    }




    private fun gameFinished() {
        if (viewModel.numberOfCorrectans.value!! >  5) {
       var action =   SecondFragmnetDirections.actionSecondFragmnetToThird(viewModel.numberOfCorrectans.value ?: 0)

            NavHostFragment.findNavController(this).navigate(action)

        } else {
          val action=  SecondFragmnetDirections.actionSecondFragmnetToLoss(viewModel.numberOfCorrectans.value ?: 0)

            NavHostFragment.findNavController(this).navigate(action)
        }
    }



}

