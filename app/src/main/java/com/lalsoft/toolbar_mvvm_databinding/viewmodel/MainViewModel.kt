package com.lalsoft.toolbar_mvvm_databinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MainViewModel:ViewModel() {
    val toolbarTitle:MutableLiveData<String> = MutableLiveData()
    val navClicked:MutableLiveData<Boolean> = MutableLiveData()

    fun navBackClicked(){
        navClicked.value=true
    }
}