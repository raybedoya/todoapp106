package com.example.todoapp106.todoapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todoapp106.TodoViewModel
import com.example.todoapp106.ui.screens.ToDoScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp() {
        viewModel = TodoViewModel()
        composeTestRule.setContent {
            ToDoScreen(viewModel = viewModel)
        }
    }

    @Test
    fun addTask_userTypesAndClicksAdd_taskAppearsInList() {
        //arrange = setUp()
        //verify task does not yet exist
        composeTestRule.onNodeWithText("Buy groceries").assertDoesNotExist()
        //find input field by its test tag
        composeTestRule
            .onNodeWithTag("input_field")
            .performTextInput("Buy groceries")

        composeTestRule
            .onNodeWithTag("add_button")
            .performClick()


        composeTestRule
            .onNodeWithText("Buy groceries")
            .assertIsDisplayed()

    }

    @Test
    fun addTask_withBlankInput_taskDoesNotAppear() {
        composeTestRule
            .onNodeWithText("")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag(testTag = "input_field")
            .performTextInput(text = "")

        composeTestRule
            .onNodeWithTag(testTag = "add_button")
            .performClick()


        composeTestRule
            .onNodeWithText("0 tasks(s)")
            .assertIsDisplayed()

    }

    @Test
    fun taskCounter_updatesAfterAddingTask() {
        composeTestRule
            .onNodeWithTag(testTag = "input_field")
            .performTextInput(text = "Do Homework")

        composeTestRule
            .onNodeWithTag(testTag = "add_button")
            .performClick()

        composeTestRule
            .onNodeWithText("1 task")
            .assertIsDisplayed()
    }


}
