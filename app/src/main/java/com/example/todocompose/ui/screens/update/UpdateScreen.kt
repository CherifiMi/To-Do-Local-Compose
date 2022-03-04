package com.example.todocompose.ui.screens

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todocompose.data.models.Priority
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.ui.screens.add.AddBtn
import com.example.todocompose.ui.screens.add.AddTitle
import com.example.todocompose.ui.screens.update.components.UpdateEntry
import com.example.todocompose.ui.screens.update.components.UpdatePrio
import com.example.todocompose.ui.viewModel.SharedViewModel


@ExperimentalComposeUiApi
@Composable
fun UpdateScreen(navController: NavController, args: Bundle?, sharedViewModel: SharedViewModel) {


    var currentId = args?.getInt("id")
    var currentTitle = args?.getString("title")
    var currentdescription = args?.getString("dis")
    var currentPriority = args?.getInt("prio")

    var Task = ToDoTask(currentId!!, currentTitle!!, currentdescription!!,

        when(currentPriority){
            1 -> Priority.LOW
            2 -> Priority.MEDIUM
            3 -> Priority.HIGH
            else->{Priority.NONE}
        }
    )


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(32.dp, 0.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        sss(4)
        AddTitle()
        sss(5)
        UpdatePrio(sharedViewModel, Task)
        sss(3)
        UpdateEntry(
            txt = "Title",
            dp = 54.dp,
            b = true,
            a = 1,
            sharedViewModel =sharedViewModel,
            task = Task
        )
        sss(3)
        UpdateEntry(
            txt = "Discription",
            dp = 384.dp,
            b = false,
            a = 2,
            sharedViewModel = sharedViewModel,
            task = Task
        )
        sss(7)
        AddBtn(Ysize = 56.dp, txt = "Update", {
            sharedViewModel.updateTaskInScreen()
            navController.popBackStack()
        })
    }
}

@Composable
fun sss(b: Int) {
    Spacer(modifier = Modifier.height((b * 8).dp))
}