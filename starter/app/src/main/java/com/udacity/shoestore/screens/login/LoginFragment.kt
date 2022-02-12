package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    // Create the buttons
    private lateinit var loginButton : Button
    private lateinit var createAccountButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        loginButton = binding.loginButton
        createAccountButton = binding.createAccountButton

        loginButton.setOnClickListener { navigateToWelcome() }
        createAccountButton.setOnClickListener { navigateToWelcome() }

        return binding.root
    }

    private fun navigateToWelcome(){
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }
}