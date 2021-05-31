package com.escodro.alkaa.kaspresso.tests

import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.screens.MenuScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test

class ExampleTests : BaseTestCase() {

    @Test
    fun exampleKaspressoTest() {
        launch().run {
            step("Добавляем таску") {
                TasksListScreen {
                    tasksRV.childAt<TasksListScreen.AddTask>(0) {
                        descriptionET.typeText("Hello")
                    }
                    device.uiDevice.pressEnter()
                }
            }

            step("Открываем меню") {
                ToolbarScreen {
                    menuButton.isVisible()
                }
            }

            step("Выбираем пункт: Work") {
                MenuScreen {
                    selectMenuItem("Work")
                }
            }

            step("Проверяем, что открыт раздел Work") {
                ToolbarScreen {
                    title.hasText("Work")
                }
            }
        }
    }
}