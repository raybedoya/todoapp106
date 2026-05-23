package com.example.todoapp106

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import android.util.Log

@SuppressLint("StaticFieldLeak")
object AppState {

    private var activityContext : Context? = null

    private val leakedActivities = mutableStateListOf<Context>()

    fun initialize(context: Context){
        activityContext = context
        leakedActivities.add(context)

        Log.w("AppState", "Context stored — leaked activities: " + leakedActivities.size + ")")
    }

}