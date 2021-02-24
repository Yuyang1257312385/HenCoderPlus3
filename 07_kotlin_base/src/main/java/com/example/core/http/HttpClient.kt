package com.example.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * @author yu
 * @description
 */
object HttpClient : OkHttpClient() {

    private val gson:Gson = Gson()

    private fun <T> convert(json:String,type: Type):T{
        return gson.fromJson(json,type)
    }

    fun <T> get(path:String,type:Type,entityCallback: EntityCallback<T>){
        val request = Request.Builder().url("https://api.hencoder.com/$path").build()
        val call = newCall(request)

        //匿名内部类用 object
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {

                entityCallback.onFail("网络异常 ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                when(response.code()){
                    in 200..300 -> {
                        try {
                            val json = response.body()?.string()
                            json?.apply {
                                entityCallback.onSuccess(convert(json,type))
                            } ?: entityCallback.onFail("json is null")
                        }catch (e:IOException){
                            e.printStackTrace()
                        }

                    }
                    in 400..500 -> entityCallback.onFail("客户端错误")
                    in 500..600 -> entityCallback.onFail("服务器错误")
                    else -> entityCallback.onFail("未知错误")

                }
            }

        })
    }


}