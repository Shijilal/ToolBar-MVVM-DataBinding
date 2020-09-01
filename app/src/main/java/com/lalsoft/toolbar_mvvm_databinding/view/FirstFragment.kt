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
import com.lalsoft.toolbar_mvvm_databinding.viewmodel.FirstViewModel

private const val TAG = "FirstFragment"

class FirstFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel
    private lateinit var dataBinding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.first_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        viewModel.toolbarTitle.observe(viewLifecycleOwner,toolbarTitleObserver)
        viewModel.btnClicked.observe(viewLifecycleOwner,btnClickedObserver)
        dataBinding.viewModel=viewModel

    }

    private val toolbarTitleObserver = Observer<String> {
        Log.e(TAG, "Title set : $it")
    }

    private val btnClickedObserver = Observer<Boolean> {
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container,
            SecondFragment()).addToBackStack(null).commit()
    }
}