package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    private lateinit var instructionsButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome, container, false)

        instructionsButton = binding.instructionButton
        instructionsButton.setOnClickListener { navigateToInstructions() }

        return binding.root
    }

    private fun navigateToInstructions(){
        val action = WelcomeFragmentDirections.actionWelcomeDestinationToInstructionsFragment()
        findNavController().navigate(action)
    }
}