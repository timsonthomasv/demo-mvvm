package com.ot.mvvm_architecture.data.repository

import com.ot.mvvm_architecture.data.api.ApiHelper
import com.ot.mvvm_architecture.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    fun getUsers(): Single<List<User>>{
        return apiHelper.getUsers()
    }
}