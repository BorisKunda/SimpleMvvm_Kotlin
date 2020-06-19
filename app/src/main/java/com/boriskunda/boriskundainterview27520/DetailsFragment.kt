package com.boriskunda.boriskundainterview27520

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.boriskunda.boriskundainterview27520.databinding.FragmentDetailsBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()//access ViewModel of activity,which fragment associates with
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.apply {

            lifecycleOwner = this@DetailsFragment
            vm = sharedViewModel

        }

        return binding.root
    }

}
