package com.ot.mvvm_architecture.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ot.mvvm_architecture.data.api.ApiHelper
import com.ot.mvvm_architecture.data.repository.MainRepository
import com.ot.mvvm_architecture.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown Class Name")
    }
}