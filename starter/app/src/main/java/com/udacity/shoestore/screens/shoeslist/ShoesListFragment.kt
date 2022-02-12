package com.udacity.shoestore.screens.shoeslist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private lateinit var binding : FragmentShoesListBinding

    private lateinit var floatingButton : FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoes_list, container, false)

        // Setup the FAB to navigate to the details destination
        floatingButton = binding.floatingActionButton
        floatingButton.setOnClickListener { navigateToShoeDetails() }

        // Let the fragment know about the menu
        setHasOptionsMenu(true)

        // Return the outermost view in the layout
        return binding.root
    }

    private fun navigateToShoeDetails(){
        val action = ShoesListFragmentDirections.actionShoesListDestinationToShoeDetails()
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}