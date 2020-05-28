package com.ot.mvvm_architecture.ui.utils

data class ResourcesUtil<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): ResourcesUtil<T>{
            return ResourcesUtil(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, msg: String): ResourcesUtil<T>{
            return ResourcesUtil(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ResourcesUtil<T>{
            return ResourcesUtil(Status.LOADING, data, null)
        }
    }
}