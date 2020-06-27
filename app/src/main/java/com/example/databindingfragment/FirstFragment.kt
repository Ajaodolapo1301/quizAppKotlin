package com.example.databindingfragment
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.databindingfragment.databinding.FragmentFirstBinding



class FirstFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, container, false)

            setHasOptionsMenu(true)


        binding.playButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_firstFragment2_to_secondFragmnet)
        )
//            Navigation.findNavController(it).navigate(R.id.action_firstFragment2_to_secondFragmnet)
//            we cn replace with
//            it.findNavController().navigate(R.id.action_firstFragment2_to_secondFragmnet)
//or

        return  binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.over_flow_menu, menu)
    }
//
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView()!!.findNavController()) ||
         super.onOptionsItemSelected(item)
    }
}
