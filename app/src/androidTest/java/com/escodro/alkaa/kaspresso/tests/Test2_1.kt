package com.escodro.alkaa.kaspresso.tests


import androidx.test.espresso.action.ViewActions.click
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Test

class `Test2_1` : BaseTestCase() {
/*

*/

    @Test
    fun test1() {
        launch().run {


        scenario(AddTaskScenario("test2"))


            step("открываем таску"){
                TasksListScreen {
                    tasksRV.childWith<TasksListScreen.Task> {withText("test2")}
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