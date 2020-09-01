package com.lalsoft.toolbar_mvvm_databinding.viewmodel

import android.util.Log

private const val TAG = "SecondViewModel"

class SecondViewModel : MainViewModel() {
    init {
        Log.e(TAG, "Inside Init")
        toolbarTitle.value="Second Fragment"
    }
}