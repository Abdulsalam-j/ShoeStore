package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    private lateinit var instructionsButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = FragmentWelcomeBinding.inflate(
            inflater, container, false
        )

        instructionsButton = binding.instructionButton
        instructionsButton.setOnClickListener { navigateToInstructions() }

        return binding.root
    }

    private fun navigateToInstructions(){
        val action = WelcomeFragmentDirections.actionWelcomeDestinationToInstructionsFragment()
        findNavController().navigate(action)
    }
}