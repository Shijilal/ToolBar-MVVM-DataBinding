package com.lalsoft.toolbar_mvvm_databinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lalsoft.toolbar_mvvm_databinding.view.common.Event

class FirstViewModel:MainViewModel() {

    private val _navigateToDetails = MutableLiveData<Event<String>>()
    val navigateToFragment: LiveData<Event<String>>
        get() = _navigateToDetails

    init {
        toolbarTitle.value="First Fragment"
    }
    fun onBtnClick(){
        _navigateToDetails.value = Event("Second Fragment")
    }
}