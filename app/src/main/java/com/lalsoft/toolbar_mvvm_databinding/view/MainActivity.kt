package com.lalsoft.toolbar_mvvm_databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lalsoft.toolbar_mvvm_databinding.R
import com.lalsoft.toolbar_mvvm_databinding.databinding.ActivityMainBinding
import com.lalsoft.toolbar_mvvm_databinding.viewmodel.MainViewModel
private const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //setSupportActionBar(dataBinding.toolbar)
        //dataBinding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        viewModel.navClicked.observe(this, navClickObserver)
        viewModel.toolbarTitle.observe(this,toolbarTitleObserver)
        dataBinding.viewModel=viewModel

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                FirstFragment()).commit()
        }

    }

    private val navClickObserver = Observer<Boolean> {
        supportFragmentManager.popBackStack()
        Log.e(TAG,"Nav Back clicked")
    }

    private val toolbarTitleObserver = Observer<String> {
        Log.e(TAG,"Title set : $it")
    }

}