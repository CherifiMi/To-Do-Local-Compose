package com.example.todocompose.navigation


sealed class Screens(val route: String) {

    object List: Screens(route = "list_screen")

    object Update: Screens(route = "update_screen/{id}/{title}/{dis}/{prio}"){
        fun passTask(id: Int, title: String, dis: String, prio: Int): String{
            return "update_screen/$id/$title/$dis/$prio"
        }
    }
}