package com.example.todocompose.ui.screens.update.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.todocompose.R
import com.example.todocompose.data.models.Priority
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.ui.theme.HighPriorityColor
import com.example.todocompose.ui.theme.LowPriorityColor
import com.example.todocompose.ui.theme.MediumPriorityColor
import com.example.todocompose.ui.viewModel.SharedViewModel



@Composable
fun UpdatePrio(sharedViewModel: SharedViewModel, Task: ToDoTask) {

    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .height(54.dp)
            .fillMaxWidth()
            .drawBehind {
                PrioBack()
            }
    ) {
        var text = "Priority"
        TextField(
            modifier = Modifier
                .offset(0.dp, -3.dp)
                .fillMaxSize(),
            value = text,
            enabled = false,
            textStyle = MaterialTheme.typography.subtitle2,
            onValueChange = {text = it},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledTextColor = Color.Black
            )

        )


        Row(
            modifier = Modifier.offset((-24).dp),
            horizontalArrangement = Arrangement.End
        ) {
            RadioBtns(sharedViewModel, Task.priority)
        }

    }


}

@Composable
fun RadioBtns(sharedViewModel: SharedViewModel, p: Priority) {

    var state1 by remember { mutableStateOf(p==Priority.LOW) }
    var state2 by remember { mutableStateOf(p==Priority.MEDIUM) }
    var state3 by remember { mutableStateOf(p==Priority.HIGH) }


    if (state1){
        sharedViewModel.updatePrioValue(1)
    }
    else if(state2){
        sharedViewModel.updatePrioValue(2)
    }else if(state3){
        sharedViewModel.updatePrioValue(3)
    }


    IconToggleButton(
        modifier = Modifier.offset((3*16).dp),
        checked = state1,
        onCheckedChange = {
            state1 = true
            state2 = false
            state3 = false
        })
    {
        Icon(imageVector = ImageVector.vectorResource(id = if (!state1)
            R.drawable.iner_sml else R.drawable.iner_big
        ),
            contentDescription ="",
            tint = LowPriorityColor
        )

        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.outer_loop ),
            contentDescription ="",
            tint = Color.Black)
    }



    IconToggleButton(
        modifier = Modifier.offset((2*16).dp),
        checked = state2,
        onCheckedChange = {
            state1 = false
            state2 = true
            state3 = false
        })
    {
        Icon(imageVector = ImageVector.vectorResource(id = if (!state2)
            R.drawable.iner_sml else R.drawable.iner_big
        ),
            contentDescription ="",
            tint = MediumPriorityColor
        )

        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.outer_loop ),
            contentDescription ="",
            tint = Color.Black)
    }



    IconToggleButton(
        modifier = Modifier.offset(16.dp),
        checked = state3,
        onCheckedChange = {
            state1 = false
            state2 = false
            state3 = true
        })
    {
        Icon(imageVector = ImageVector.vectorResource(id = if (!state3)
            R.drawable.iner_sml else R.drawable.iner_big
        ),
            contentDescription ="",
            tint = HighPriorityColor
        )

        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.outer_loop ),
            contentDescription ="",
            tint = Color.Black)
    }


}


fun DrawScope.PrioBack(){



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
            width = 4f
        )
    )

}