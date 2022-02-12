package com.udacity.shoestore.screens.shoeslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<Shoe>()
    val word:LiveData<Shoe> get() = _shoesList
}