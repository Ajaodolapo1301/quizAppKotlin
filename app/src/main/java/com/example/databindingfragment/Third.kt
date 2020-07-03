package com.example.databindingfragment


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.databindingfragment.databinding.FragmentThirdBinding


class Third : Fragment() {
    private lateinit var viewModel: ThirdViewModel
    private lateinit var viewModelFactory: ThirdViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentThirdBinding>(inflater, R.layout.fragment_third, container, false)


        setHasOptionsMenu(true)


        binding.playAgain.setOnClickListener {
            it.findNavController().navigate(R.id.action_third_to_secondFragmnet)

        }


        viewModelFactory = ThirdViewModelFactory(ThirdArgs.fromBundle(requireArguments()).numCorrect)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ThirdViewModel::class.java)

//        var args = ThirdArgs.fromBundle(requireArguments())
//
            binding.textView2.text = "You are a Champion,You scored ${ThirdArgs.fromBundle(requireArguments()).numCorrect.toString()} / 10"


        return  binding.root


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner, menu)

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)){
           menu.findItem(R.id.share).setVisible(false)
        }



    }


    private  fun getShareIntent():Intent {
        var args = ThirdArgs.fromBundle(requireArguments())

        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.share_success_text, args.numCorrect))
            .setType("text/plain")
            .intent

//        var shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect))
//        return  shareIntent
    }



//LONG WAY
        private fun shareSuccess(){
            startActivity(getShareIntent())
        }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }





}