package com.example.todocompose.ui.screens.list.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todocompose.data.models.Priority
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.navigation.Screens
import com.example.todocompose.ui.theme.*
import com.example.todocompose.ui.viewModel.SharedViewModel
import kotlin.math.absoluteValue
import kotlin.random.Random

@Composable
fun TaskCard(t: ToDoTask,navController: NavController, viewModel: SharedViewModel ) {

    var offX by remember { mutableStateOf(0)}

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .offset(offX.dp)
            .clickable {
                navController.navigate(route = Screens.Update.passTask(
                    t.id,
                    t.title,
                    t.description,
                    when(t.priority){
                        Priority.LOW -> 1
                        Priority.MEDIUM -> 2
                        Priority.HIGH -> 3
                        else -> {0}
                    }
                ))
            }
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    offX = offX + dragAmount.toInt()
                    //Log.d("HILLO", offX.toString())
                    if(offX >= 250){
                        viewModel.deleteTask(t)
                        offX = 0
                    }

                }

            }
            .rotate(
                degrees = if ((t.id%2)==0) 1.55f else -1.55f

            )
            .background(Color.White)
            .padding(32.dp, 16.dp)
            //.height(104.dp)
            .fillMaxWidth()
            .drawBehind {
                coluomBackDach()
                coluomBack()
            }
    )
    {
        Row(
            Modifier
                .padding(24.dp, 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        )
        {
            Text(
                modifier = Modifier.weight(14f),
                text = t.title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 19.sp,
                    fontFamily = baloo,
                    color = Color.Black
                )
            )


            Spacer(
                modifier = Modifier
                    .weight(1f))

            Card(
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
                    .weight(1f),
                border = BorderStroke(2.dp, Color.Black),
                backgroundColor = when(t.priority){
                    Priority.LOW-> LowPriorityColor
                    Priority.MEDIUM-> MediumPriorityColor
                    Priority.HIGH-> HighPriorityColor
                    else->{ NonePriorityColor}
                } as Color,
                shape = CircleShape
            ) {}
        }

        Text(
            text = t.description,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                fontFamily = baloo,
                color = Color.Black
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 3,
            modifier = Modifier
                .padding(24.dp, 0.dp, 50.dp, 8.dp)
                .offset(0.dp, (-8).dp)
            )
    }

}

fun DrawScope.coluomBack() {
    drawRoundRect(
        color = Color.White,
        size = size,
        cornerRadius = CornerRadius(30f),

        )
    drawRoundRect(
        color = Color.Black,
        size = size,
        cornerRadius = CornerRadius(30f),
        style =
        Stroke(
            width = 4f,
        )
    )
}

fun DrawScope.coluomBackDach() {

    drawRoundRect(
        color = Color.White,
        size = size,
        topLeft = Offset(2f,8f),
        cornerRadius = CornerRadius(30f),

        )
    drawRoundRect(
        color = Color.Black,
        size = size,
        topLeft = Offset(8f,8f),
        cornerRadius = CornerRadius(30f),
        style =
        Stroke(
            cap = StrokeCap.Round,
            width = 4f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
    )
}
