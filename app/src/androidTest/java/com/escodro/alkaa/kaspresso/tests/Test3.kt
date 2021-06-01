package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Test

class Test3 : BaseTestCase() {
/*

*/

    @Test
    fun test1() {
        launch().run {


        scenario(AddTaskScenario("test3"))


            step("открываем таску"){
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0){
                    click()
                }

            }

            step("меняем имя и назад в корень "){
                TaskDetailsScreen {
                    taskname.clearText()
                    taskname.typeText("new")
                }
                // device.uiDevice.pressBack() /*not working*/
                device.uiDevice.click(50, 120)
            }
            step ("тмечаем таску как готовую"){
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0){
                    taskCheckBox.click()
                }

            }

        }
    }
}