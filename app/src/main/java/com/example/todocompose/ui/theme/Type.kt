package com.example.todocompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.unit.sp
import com.example.todocompose.R

val baloo = FontFamily(
    Font(R.font.baloo_regular, weight = FontWeight.Normal),
    Font(R.font.baloo_medium, weight = FontWeight.Medium),
    Font(R.font.baloo_bold, weight = FontWeight.Bold),
    Font(R.font.baloo_semibold, weight = FontWeight.SemiBold),
    Font(R.font.baloo_extrabold, weight = FontWeight.ExtraBold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        fontFamily = baloo
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        fontFamily = baloo,
        color = Color.Black
    ),
    subtitle2 = TextStyle(
        fontFamily = baloo,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),



)