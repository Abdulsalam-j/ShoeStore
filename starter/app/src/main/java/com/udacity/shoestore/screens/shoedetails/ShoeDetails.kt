package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.screens.shoeslist.ShoesListViewModel

class ShoeDetails : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoesListViewModel by activityViewModels()
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_details, container, false)

        saveButton = binding.saveButton
        saveButton.setOnClickListener { saveShoe() }

        cancelButton = binding.cancelButton
        cancelButton.setOnClickListener { cancelShoe() }

        return binding.root
    }

    private fun saveShoe() {
        val name = binding.shoeNameEditText.text.toString()
        val company = binding.shoeCompanyEditText.text.toString()
        var size = binding.shoeSizeEditText.text.toString()
        if (size == "") size = 0.0.toString()
        val newSize = size.toDouble()
        val description = binding.descriptionEditText.text.toString()
        viewModel.addShoe(name, company, newSize, description)
        navigateToShoeList()
    }

    private fun cancelShoe() {
        navigateToShoeList()
    }

    private fun navigateToShoeList() {
        val action = ShoeDetailsDirections.actionShoeDetailsToShoesListDestination()
        findNavController().navigate(action)
    }
}