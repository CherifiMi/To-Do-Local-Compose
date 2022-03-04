package com.example.todocompose.ui.screens.update.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todocompose.R
import com.example.todocompose.ui.theme.baloo


@Composable
fun UpdateTitle() {
    Box(
        modifier = Modifier.size(153.dp,72.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.stars),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "Update Task",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.sp,
                fontFamily = baloo,
                color = Color.Black
            )
        )
    }
}