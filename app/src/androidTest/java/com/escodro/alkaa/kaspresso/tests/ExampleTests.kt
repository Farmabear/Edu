package com.escodro.alkaa.kaspresso.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.screens.MenuScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
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
                    menuButton.click()
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