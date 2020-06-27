package com.example.databindingfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.databindingfragment.databinding.FragmentLossBinding


class Loss : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      var binding = DataBindingUtil.inflate<FragmentLossBinding>(inflater, R.layout.fragment_loss, container, false)
            binding.button.setOnClickListener {
                it.findNavController().navigate(R.id.action_loss_to_secondFragmnet)
            }




        var args = LossArgs.fromBundle(requireArguments())

        binding.message.text = "You can do better next time,You scored ${args.numOfQues} / 10"
        return  binding.root
    }


}
