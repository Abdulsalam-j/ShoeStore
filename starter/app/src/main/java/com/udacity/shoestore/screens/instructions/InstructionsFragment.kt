package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = FragmentInstructionsBinding.inflate(
            inflater, container, false
        )

        binding.shoeListButton.setOnClickListener { navigateToShoesList() }

        return binding.root
    }

    private fun navigateToShoesList() {
        val action = InstructionsFragmentDirections
            .actionInstructionsDestinationToShoesListFragment()
        findNavController().navigate(action)
    }
}