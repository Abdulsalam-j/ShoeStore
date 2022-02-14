package com.udacity.shoestore.screens.shoeslist

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel(), Observable {

    // Utility class for managing Observable callbacks
    private val propertyChangeRegistry = PropertyChangeRegistry()

    // ShoeList encapsulated LiveData
    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: MutableLiveData<MutableList<Shoe>> get() = _shoesList

    init {
        _shoesList.value = ArrayList()
    }

    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoe)
            }
        }

    fun addShoe(shoe: Shoe) {
        _shoesList.value?.add(shoe)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

}