package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.screens.shoeslist.ShoesListFragment
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    // Create the button
    lateinit var shoesListButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_instructions, container, false)

        shoesListButton = binding.shoeListButton
        shoesListButton.setOnClickListener { navigateToShoesList() }

        return binding.root
    }

    private fun navigateToShoesList(){
        val action = InstructionsFragmentDirections.actionInstructionsDestinationToShoesListFragment()
        findNavController().navigate(action)
    }
}