package com.example.todoapp106

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import android.util.Log

@SuppressLint("StaticFieldLeak")
object AppState {

    private var activityContext : Context? = null

    private val leakedActivity = mutableStateListOf<Context>()

    fun initialize(context: Context){
        activityContext = context.applicationContext
        leakedActivity.add(context)

        Log.d("AppState", "Safe context stored- Application context never leaks")
    }

}