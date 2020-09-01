package com.lalsoft.toolbar_mvvm_databinding.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "MainViewModel"

open class MainViewModel : ViewModel() {
    val toolbarTitle: MutableLiveData<String> = MutableLiveData()
    private val _navClicked: MutableLiveData<Boolean> = MutableLiveData()
    val navClicked: LiveData<Boolean> = _navClicked
    init {
        Log.e(TAG, "Inside Init")
        //toolbarTitle.value ="Main Activity"
    }

    fun navBackClicked() {
        _navClicked.value = true
    }

}