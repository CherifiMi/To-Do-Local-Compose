package com.example.todocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todocompose.ui.screens.AddScreen
import com.example.todocompose.ui.screens.ListScreen
import com.example.todocompose.ui.screens.UpdateScreen
import com.example.todocompose.ui.viewModel.SharedViewModel


@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun Navigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    NavHost(navController, startDestination = Screens.List.route) {

        composable(route = Screens.List.route) {
            ListScreen(navController, sharedViewModel)
        }

        composable(
            route = Screens.Update.route,
            arguments = listOf(
                navArgument("id") {type = NavType.IntType},
                navArgument("title") {type = NavType.StringType},
                navArgument("dis") {type = NavType.StringType},
                navArgument("prio") {type = NavType.IntType}
            )
        )
        {
            var args = it.arguments
            UpdateScreen(navController, args, sharedViewModel)

        }
    }
}