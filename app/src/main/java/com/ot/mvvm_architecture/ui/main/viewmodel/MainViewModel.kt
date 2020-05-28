package com.ot.mvvm_architecture.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ot.mvvm_architecture.data.model.User
import com.ot.mvvm_architecture.data.repository.MainRepository
import com.ot.mvvm_architecture.ui.utils.ResourcesUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {
    private val users = MutableLiveData<ResourcesUtil<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUser()
    }
    private fun fetchUser(){
        users.postValue(ResourcesUtil.loading(null))
        val getUserRepository = mainRepository.getUsers()
                                 .subscribeOn(Schedulers.io())
                                  .observeOn(AndroidSchedulers.mainThread())
                                 .subscribe({userList -> users.postValue(ResourcesUtil.success(userList))},
                                      {throwable -> users.postValue(ResourcesUtil
                                          .error(null, "something went wrong"))})
        compositeDisposable.add(getUserRepository)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<ResourcesUtil<List<User>>>{
        return users
    }

}