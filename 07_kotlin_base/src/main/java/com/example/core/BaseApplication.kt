package com.example.core

import android.app.Application
import android.content.Context

/**
 * @author yu
 * @description
 */
class BaseApplication : Application(){

    companion object{
        var currentApplication:Context? = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = base
    }

}