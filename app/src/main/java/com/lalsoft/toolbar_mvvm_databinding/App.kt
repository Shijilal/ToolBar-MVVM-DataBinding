package com.lalsoft.toolbar_mvvm_databinding

import android.app.Application

class App:Application() {
    companion object{
//        lateinit var toolbarTitle:String
    }

    override fun onCreate() {
        super.onCreate()
        //toolbarTitle="Main Activity"
    }
}