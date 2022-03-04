package com.example.todocompose.ui.screens.add

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todocompose.R
import com.example.todocompose.ui.theme.BtnColor


@Composable
fun AddXIcon(clicked:()->Unit) {
    IconButton(
        modifier = Modifier.size(40.dp).offset(0.dp, (-20).dp),
        onClick = {clicked()}
    ){
        Icon(painter = painterResource(R.drawable.x_icon) , contentDescription = "", tint = Color.Black)
        Icon(painter = painterResource(R.drawable.x) , contentDescription = "", tint = Color.White)
    }

}