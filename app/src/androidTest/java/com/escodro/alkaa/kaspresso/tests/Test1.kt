package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
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
                    device.uiDevice.pressEnter()
                }
            }


        }
    }
}