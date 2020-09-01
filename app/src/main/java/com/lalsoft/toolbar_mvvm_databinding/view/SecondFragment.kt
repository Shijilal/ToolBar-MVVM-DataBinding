package com.lalsoft.toolbar_mvvm_databinding.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lalsoft.toolbar_mvvm_databinding.R
import com.lalsoft.toolbar_mvvm_databinding.databinding.FirstFragmentBinding
import com.lalsoft.toolbar_mvvm_databinding.databinding.SecondFragmentBinding
import com.lalsoft.toolbar_mvvm_databinding.viewmodel.FirstViewModel
import com.lalsoft.toolbar_mvvm_databinding.viewmodel.SecondViewModel

private const val TAG = "SecondFragment"

class SecondFragment : Fragment() {
    private lateinit var viewModel: SecondViewModel
    private lateinit var dataBinding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.second_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        viewModel.toolbarTitle.observe(viewLifecycleOwner,toolbarTitleObserver)
        //viewModel.navClicked.observe(viewLifecycleOwner,navClickObserver)

    }

    private val toolbarTitleObserver = Observer<String> {
        Log.e(TAG, "Title set : $it")
    }

    private val navClickObserver = Observer<Boolean> {

        //Log.e(TAG,"Nav Back clicked First")
    }
}