package com.example.todoapp106.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp106.Task
import com.example.todoapp106.TodoViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.testTag


@Composable
fun ToDoScreen(viewModel: TodoViewModel){
    var inputText by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Spacer( modifier = Modifier.height(24.dp))
        Text(
            text = "My to do List",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = {inputText = it},
                placeholder = {Text("Enter a Task...")},
                modifier = Modifier
                    .weight(1f)
                    .testTag("input_field"),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    viewModel.addTask(inputText)
                    inputText = ""
                },
                modifier = Modifier.testTag("add button")
            ){
                Text("Add")
            }
        }//end of Row
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "${viewModel.task.size} task(s)",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )
          //Scrollable list of task
        //LazyColumn only renders items that are visible on screen
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                items = viewModel.task,
                key = {task -> task.id}
            ){ task ->
                TaskItem(
                    task = task,
                    onDelete = {viewModel.removeTask(taskId = task.id)}
                )
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onDelete: () ->Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = task.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = onDelete
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Task"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoScreenPreview(){
    ToDoScreen(viewModel = TodoViewModel())
}