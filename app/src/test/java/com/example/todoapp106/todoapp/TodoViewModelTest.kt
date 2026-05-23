package com.example.todoapp106.todoapp

import com.example.todoapp106.TodoViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {
    //recreated before each test
    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp() {
        viewModel = TodoViewModel()
    }

    @Test

    fun add_Task_withValidTitle_appearsInList(){

        // Arrange - The setUp() already created and empty ViewModel
        // Act -- Call the function we want to test
        viewModel.addTask("Do exercise")
        // Asser-- Verify the result
        assertEquals(1,viewModel.getTaskCount())
        assertTrue(viewModel.containsTask("Do exercise"))
    }

    @Test
    fun add_Task_withBlankTitle_isIgnored(){
        viewModel.addTask("Do exercise")
        assertTrue(viewModel.containsTask("Do Exercise"))
    }

    @Test
    fun add_Task_withEmptyString_isIgnored(){
        viewModel.addTask("")
        assertTrue(viewModel.containsTask("Do Exercise"))

    }

    @Test
    fun add_Task_titleIsTrimmed(){
        viewModel.addTask("  Do  Exercise ")
        assertTrue(viewModel.containsTask("Do Exercise"))
    }

    @Test
    fun removeTask_withValidId_removesTask(){
        viewModel.addTask("Do Exercise")
        val taskId = viewModel.task[0].id
        viewModel.removeTask(taskId)
        assertEquals(0,viewModel.getTaskCount())
        assertFalse(viewModel.containsTask("Do Exercise"))
    }

    @Test
    fun removeTask_withInvalidId_doesNothing(){
        viewModel.addTask("Do Exercise")
        viewModel.removeTask(99)
        assertEquals(1,viewModel.getTaskCount())

    }

}