package com.example.todoapp106

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp106.ui.screens.ToDoScreen
import com.example.todoapp106.ui.theme.Todoapp106Theme

class MainActivity : ComponentActivity() {
    //view models creates the viewmodel and keep it alive during config changes
    private val viewModel: TodoViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Todoapp106Theme {
                Surface(color = MaterialTheme.colorScheme.background){
                    ToDoScreen(viewModel = viewModel)
                }

            }
        }
    }

}
