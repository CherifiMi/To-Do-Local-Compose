package com.example.todocompose.ui.screens.add

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
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
import com.example.todocompose.ui.theme.*
import com.example.todocompose.ui.viewModel.SharedViewModel


@Composable
fun addEntry(txt: String, dp: Dp, b: Boolean, SetVal: Int, sharedViewModel: SharedViewModel) {

    var text by remember { mutableStateOf("") }

    when(SetVal){
        1-> sharedViewModel.titleValue(text)
        2-> sharedViewModel.discValue(text)
        else->{}
    }

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
            textStyle = typography.subtitle2,
            singleLine = b,
            onValueChange = {
                text = it },
            placeholder = {
                Text(
                    text = txt,
                    style = typography.subtitle2,
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



