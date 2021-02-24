package com.example.core.http

/**
 * @author yu
 * @description
 */
interface EntityCallback<T> {

    fun onSuccess(entity:T)

    fun onFail(message:String?)

}