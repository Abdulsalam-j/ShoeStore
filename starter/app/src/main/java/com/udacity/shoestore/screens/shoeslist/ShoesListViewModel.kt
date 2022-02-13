package com.udacity.shoestore.screens.shoeslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: MutableLiveData<MutableList<Shoe>> get() = _shoesList

    init {
        _shoesList.value = ArrayList()
    }

    fun addShoe(name: String, company: String, size: Double, description: String) {
        val shoe = Shoe(name, size, company,description )
        _shoesList.value?.add(shoe)
    }
}