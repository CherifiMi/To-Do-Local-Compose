package com.example.todocompose.ui.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.datastore.preferences.core.emptyPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todocompose.MainActivity
import com.example.todocompose.data.models.Priority
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {



    private val _allTasks =
        MutableStateFlow<List<ToDoTask>>(emptyList())

    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

   // private val _selectedTask =
   //     MutableStateFlow<ToDoTask>(ToDoTask(0,"","",Priority.NONE))
   // val selectedTask: StateFlow<ToDoTask> = _selectedTask

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)

    val taskprio = mutableStateOf(0)
    val tasktitle = mutableStateOf("")
    val taskdis = mutableStateOf("")

    val updatetaskid = mutableStateOf(0)
    val updatetaskprio = mutableStateOf(0)
    val updatetasktitle = mutableStateOf("")
    val updatetaskdis = mutableStateOf("")


    val addscreenanim = mutableStateOf(false)



    fun getAllTasks(){
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }

    fun addTask(task: ToDoTask){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }
    fun updateTask(task: ToDoTask){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: ToDoTask){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTask(task)
        }
    }

    fun addTaskInScreen(){
            if(
                tasktitle.value.isNotEmpty()&&
                taskdis.value.isNotEmpty()&&
                taskprio.value>0){
                addTask(
                    ToDoTask(
                        0,
                        tasktitle.value,
                        taskdis.value,
                        priority =
                        when(taskprio.value){
                            1->Priority.LOW
                            2->Priority.MEDIUM
                            3->Priority.HIGH
                            else->{Priority.NONE}
                        }
                    )
                )

                prioValue(0)
                titleValue("")
                discValue("")

                    this.addScreenAnim(false)

                Log.d("HILLO", "YESSSS")

            }else{
                Log.d("HILLO", "NOOOOO")
            }
    }

    fun updateTaskInScreen(){
        if(
            updatetasktitle.value.isNotEmpty()&&
            updatetaskdis.value.isNotEmpty()&&
            updatetaskprio.value>0){

            Log.d("HILLOUPDATE", updatetasktitle.value)

            updateTask(
                ToDoTask(
                    updatetaskid.value,
                    updatetasktitle.value,
                    updatetaskdis.value,
                    when(updatetaskprio.value){
                        1->Priority.LOW
                        2->Priority.MEDIUM
                        3->Priority.HIGH
                        else->{Priority.NONE}
                    }
                )
            )

            updatePrioValue(0)
            updateTitleValue("")
            updateDiscValue("")

            Log.d("HILLO", "YESSSS")

        }else{
            Log.d("HILLO", "NOOOOO")
        }
    }

    fun prioValue(b: Int) {
        this.taskprio.value = b
    }
    fun titleValue(text: String) {
        this.tasktitle.value = text
    }
    fun discValue(text: String) {
        this.taskdis.value = text
    }

    fun updateIdValue(b:Int){
        this.updatetaskid.value = b
    }
    fun updatePrioValue(b: Int) {
        this.taskprio.value = b
    }
    fun updateTitleValue(text: String) {
        this.tasktitle.value = text
    }
    fun updateDiscValue(text: String) {
        this.taskdis.value = text
    }

    fun addScreenAnim(b: Boolean){
        this.addscreenanim.value = b
    }

}

