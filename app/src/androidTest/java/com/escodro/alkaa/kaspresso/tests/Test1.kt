package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test

class Test1 : BaseTestCase() {

    @Test
    fun test1() {
        launch().run {
            step("Создаем таску") {
                TasksListScreen {
                    tasksRV.childAt<TasksListScreen.AddTask>(0) {
                        descriptionET.typeText("Hello")
                    }
//                     device.uiDevice.pressEnter() /*not working*/
                    device.uiDevice.click(950, 1700)

                    step("Проверям что отрисовалось") {
                        TasksListScreen {
                            tasksRV.childAt<TasksListScreen.Task>(0){
                                taskName.hasText("Hello")
                            }
                        }
                    }
                }


            }
        }
    }
}