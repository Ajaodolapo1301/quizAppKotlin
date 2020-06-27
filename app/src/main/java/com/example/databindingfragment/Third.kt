package com.example.databindingfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.databindingfragment.databinding.FragmentThirdBinding


class Third : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentThirdBinding>(inflater, R.layout.fragment_third, container, false)
        binding.playAgain.setOnClickListener {
            it.findNavController().navigate(R.id.action_third_to_secondFragmnet)

        }
        
        var args = ThirdArgs.fromBundle(requireArguments())

            binding.textView2.text = "You are a Champion,You scored ${args.numCorrect} / 10"


        return  binding.root


    }


}