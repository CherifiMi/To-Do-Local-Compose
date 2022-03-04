package com.example.todocompose.ui.screens.add

import android.util.Log
import android.view.MotionEvent.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.todocompose.ui.theme.BtnColor
import com.example.todocompose.ui.theme.BtnBackColor


@ExperimentalComposeUiApi
@Composable
fun AddBtn(Ysize: Dp, txt: String, clicked:()->Unit ) {
    var yO = remember{ mutableStateOf(0.dp)}

    Button(
        modifier = Modifier
            .pointerInteropFilter {
                when (it.action) {
                    ACTION_DOWN -> {
                        yO.value = 4.dp
                    }
                    ACTION_UP -> {
                        yO.value = 0.dp
                        clicked()
                    }
                    else ->  false
                }
                true
            }
            .fillMaxWidth()
            .height(Ysize)
            .offset(0.dp,yO.value)
            .drawBehind { btnBack(0f,4f-yO.value.value) },
        colors = ButtonDefaults.buttonColors(BtnColor),
        border = BorderStroke(2.dp, Color.Black),
        shape = RoundedCornerShape(100.dp),
        onClick = {}
    ){
        Text(
            text = txt,
            style = typography.button
        )
    }
}



fun DrawScope.btnBack(xOff: Float, yOff: Float ){


    drawRoundRect(
        color = Color.Black,
        size = size,
        topLeft = Offset(xOff,yOff),
        cornerRadius = CornerRadius(100f),
        style =
        Stroke(
            cap = StrokeCap.Round,
            width = 4f
            //pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
    )
    drawRoundRect(
        color = BtnBackColor,
        size = size,
        topLeft = Offset(xOff,yOff),
        cornerRadius = CornerRadius(100f),

    )

}

