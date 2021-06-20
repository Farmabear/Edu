package com.escodro.alkaa.kaspresso.tests.archive


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Test

class Test2 : BaseTestCase() {
/*

*/

    @Test
    fun test2() {
        launch().run {


        scenario(AddTaskScenario("test2"))


            step("открываем таску"){
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0){
                    click()
                }

            }

            step("меняем имя"){
                TaskDetailsScreen {
                    taskname.clearText()
                    taskname.typeText("new")
                    //replacetext
                   // taskname.hasText("new")
                }
            }

        }
    }
}