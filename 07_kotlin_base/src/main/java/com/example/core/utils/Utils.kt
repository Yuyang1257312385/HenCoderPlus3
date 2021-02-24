package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * @author yu
 * @description
 */

fun toast(string:String){
    toast(string,Toast.LENGTH_SHORT)
}

fun toast(string:String,duration:Int){
    Toast.makeText(BaseApplication.currentApplication,string,duration).show()
}

object Utils {

    private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

    @JvmStatic
    fun dp2px(dp:Float): Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, displayMetrics)
    }

    fun px2dp(px:Float) : Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,px, displayMetrics)
    }

}