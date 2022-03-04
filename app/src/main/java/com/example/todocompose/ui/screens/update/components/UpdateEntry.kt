package com.example.todocompose.ui.screens.update.components

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.ui.theme.EntryBackColor
import com.example.todocompose.ui.theme.EntryPlaceholderColor
import com.example.todocompose.ui.viewModel.SharedViewModel
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes


@Composable
fun UpdateEntry(
    txt: String,
    dp: Dp,
    b: Boolean,
    a: Int,
    sharedViewModel: SharedViewModel,
    task: ToDoTask
) {

    var oldtext: String = when(a) {
        1-> task.title
        2->task.description
        else -> {""}
    }

    var text: String by remember { mutableStateOf(oldtext)}


    sharedViewModel.updateIdValue(task.id)
    sharedViewModel.updateTitleValue(task.title)
    sharedViewModel.updateDiscValue(task.description)


    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .height(dp)
            .drawBehind {
                entryBack()
            }) {

        TextField(
            modifier = Modifier
                .fillMaxSize()
                .offset(0.dp, -3.dp),
            value = text,
            textStyle = MaterialTheme.typography.subtitle2,
            singleLine = b,
            onValueChange = {
                text = it },
            placeholder = {
                Text(
                    text = txt,
                    style = MaterialTheme.typography.subtitle2,
                    color = EntryPlaceholderColor
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.Black
            )

        )
    }



}

fun DrawScope.entryBack(){

    drawRoundRect(
        color = EntryBackColor,
        size = size,
        cornerRadius = CornerRadius(30f),

        )
    drawRoundRect(
        color = Color.Black,
        size = size,
        cornerRadius = CornerRadius(30f),
        style =
        Stroke(
            width = 4f
        )
    )

}
