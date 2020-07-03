package com.example.databindingfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.databindingfragment.databinding.FragmentRulesBinding


class Rules : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     var binding = DataBindingUtil.inflate<FragmentRulesBinding>(inflater, R.layout.fragment_rules, container, false)


        return  binding.root
    }


}
