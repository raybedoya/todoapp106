package com.example.todoapp106.todoapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.todoapp106.TodoViewModel
import com.example.todoapp106.ui.screens.ToDoScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp(){
        viewModel = TodoViewModel()
        composeTestRule.setContent {
            ToDoScreen(viewModel = viewModel)
        }
    }

    @Test
    fun addTask_userTypesAndClicksAdd_taskAppearsInList(){
        //arrange = setUp()
        //verify task does not yet exist
        composeTestRule.onNodeWithText("Buy groceries").assertDoesNotExist()
        //find input field by its test tag
        composeTestRule
            .onNodeWithTag(testTag = "input_field")
            .performTextInput(text = "Buy groceries")

        composeTestRule
            .onNodeWithTag(testTag = "add_button")
            .performClick()


        composeTestRule
            .onNodeWithText("0 tasks(s)")
            .assertIsDisplayed()

        @Test
        fun addTask_withBlankInput_taskDoesNotAppear(){

        }


    }
}