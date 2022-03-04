package com.example.todocompose.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.todocompose.ui.screens.add.*
import com.example.todocompose.ui.viewModel.SharedViewModel


@ExperimentalComposeUiApi
@Composable
fun AddScreen(sharedViewModel: SharedViewModel){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(440.dp, 700.dp)
    ){



    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
        ){

        Column(
            modifier = Modifier
                .size(440.dp, 658.dp)
                .offset(-50.dp)
                .drawBehind {
                    coluomBackDach()
                    coluomBack()
                }
                .padding(82.dp, 0.dp, 32.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            AddXIcon({
                sharedViewModel.addScreenAnim(false)
            })
            AddTitle()
            SPEACE()
            AddPrio(sharedViewModel)
            SPEACE()
            addEntry("Title",54.dp,true, 1, sharedViewModel)
            SPEACE()
            // * use Spacer(modifier = ) next time :)
            addEntry("Discription",304.dp,false, 2, sharedViewModel)
            SPEACE()
            SPEACE()
            AddBtn(52.dp, "Add", {
                sharedViewModel.addTaskInScreen()
            })
        }
    }
    }

}

@Composable
fun SPEACE() {
    Box(modifier = Modifier.height(16.dp)){}
}



fun DrawScope.coluomBack() {

    drawRoundRect(
        color = Color.White,
        size = size,
        cornerRadius = CornerRadius(100f),

        )
    drawRoundRect(
        color = Color.Black,
        size = size,
        cornerRadius = CornerRadius(100f),
        style =
        Stroke(
            width = 4f
        )
    )
}
fun DrawScope.coluomBackDach() {

    drawRoundRect(
        color = Color.White,
        size = size,
        topLeft = Offset(0f,8f),
        cornerRadius = CornerRadius(100f),

        )
    drawRoundRect(
        color = Color.Black,
        size = size,
        topLeft = Offset(0f,8f),
        cornerRadius = CornerRadius(100f),
        style =
        Stroke(
            cap = StrokeCap.Round,
            width = 4f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
    )
}
