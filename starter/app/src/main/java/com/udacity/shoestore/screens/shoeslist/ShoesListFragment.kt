package com.udacity.shoestore.screens.shoeslist

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private lateinit var binding : FragmentShoesListBinding

    private lateinit var floatingButton : FloatingActionButton

    private val viewModel: ShoesListViewModel by activityViewModels()

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

        viewModel.shoesList.observe(viewLifecycleOwner) { newShoeList ->
            for (item in newShoeList.listIterator()) {
                val name = TextView(this.context)
                name.text = item.name
                val size = TextView(this.context)
                size.text = item.size.toString()
                val company = TextView(this.context)
                company.text = item.company
                val description = TextView(this.context)
                description.text = item.description

                // Increase the text size
                name.textSize = 26F
                size.textSize = 24F
                company.textSize = 24F
                description.textSize = 18F

                // Parent layout for our views
                val parentLayout = LinearLayout(this.context)
                parentLayout.orientation = LinearLayout.VERTICAL
                parentLayout.setPadding(16, 16, 16, 16)

                // Layout Parameters to set the parent layout with
                val layoutParams = LinearLayout.LayoutParams(
                    /*width*/
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    /*height*/
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                // Adding the views
                parentLayout.addView(name)
                parentLayout.addView(size)
                parentLayout.addView(company)
                parentLayout.addView(description)

                // Add the layout to the base layout resource
                binding.shoeListLinearLayout.addView(parentLayout, layoutParams)
            }
        }

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