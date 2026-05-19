package com.example.todoapp106

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val task : List<Task> get() = _tasks

    private var nextId = 1

    fun addTask(title: String){
        if(title.isNotBlank()){
            _tasks.add(Task(id = nextId++, title = title.trim()) )
        }
    }
    fun removeTask(taskId: Int){
        _tasks.removeAll { it.id == taskId}
    }

    fun getTaskCount(): Int = _tasks.size

    fun containsTask(title:String):Boolean{
        return _tasks.any{it.title == title}
    }
}