package com.example.todocompose.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todocompose.ui.screens.add.AddBtn
import com.example.todocompose.ui.screens.list.components.TaskCard
import com.example.todocompose.ui.viewModel.SharedViewModel


@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun ListScreen(navController: NavController, sharedViewModel: SharedViewModel){

    var state by remember { mutableStateOf(false) }

    Animations(sharedViewModel)

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column {
            TopBar(sharedViewModel)
            TasksCard(sharedViewModel, navController)
        }
        btn(sharedViewModel, hight = 48, text = "Add")
        Animations(sharedViewModel)


    }
}

@Composable
fun TopBar(sharedViewModel: SharedViewModel) {
    Row(

    ) {
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun TasksCard(sharedViewModel: SharedViewModel, navController: NavController) {
    sharedViewModel.getAllTasks()
    val tasks by sharedViewModel.allTasks.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ){

        items(items = tasks){
            TaskCard(it, navController, sharedViewModel)
        }

    }

}



@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Animations(sharedViewModel: SharedViewModel) {
    AnimatedVisibility(
        visible = sharedViewModel.addscreenanim.value,
        enter =  fadeIn(),
        exit =  fadeOut()
    ) {
        Blur()
    }

    AnimatedVisibility(
        visible = sharedViewModel.addscreenanim.value,
        enter = expandHorizontally()+ fadeIn(),
        exit = shrinkHorizontally() + fadeOut()
    ) {
        AddScreen(sharedViewModel = sharedViewModel)
    }
}

@ExperimentalComposeUiApi
@Composable
fun btn(sharedViewModel: SharedViewModel, hight: Int, text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row() {
            Box(
                Modifier
                    .weight(1f)
                    .padding(32.dp, 0.dp, 0.dp, 50.dp)) {
                AddBtn(Ysize = hight.dp, txt = text) {
                    sharedViewModel.addScreenAnim(true)
                }}
            Spacer(Modifier.weight(3f))
        }
    }
}

@Composable
fun Blur() {

    Surface(color = Color(0xD3FFFFFF), modifier = Modifier.fillMaxSize()) {}

    //makes app performance worst

    /*AndroidView(
        factory = { context: Context ->
            val view = LayoutInflater.from(context)
                .inflate(R.layout.blur_layout, null, false)

            view
        }
    )*/
}





