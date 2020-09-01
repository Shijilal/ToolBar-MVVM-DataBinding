package com.lalsoft.toolbar_mvvm_databinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FirstViewModel:MainViewModel() {
    private val _btnClicked:MutableLiveData<Boolean> = MutableLiveData()
    val btnClicked:LiveData<Boolean> = _btnClicked

    init {
        toolbarTitle.value="First Fragment"
    }
    fun onBtnClick(){
        _btnClicked.value=true
    }
}