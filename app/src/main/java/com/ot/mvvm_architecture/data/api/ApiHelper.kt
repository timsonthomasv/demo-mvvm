package com.ot.mvvm_architecture.data.api

class ApiHelper(private val apiService: ApiService) {
    fun getUsers() = apiService.getUsers()
}