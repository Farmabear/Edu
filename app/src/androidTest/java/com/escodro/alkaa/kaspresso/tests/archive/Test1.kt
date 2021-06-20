package com.escodro.alkaa.kaspresso.tests.archive


import android.view.KeyEvent
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test

class Test1 : BaseTestCase() {

    @Test
    fun test1() {
        launch().run {
            TasksListScreen {
                step("Setting Task with name test") {

                    descriptionET.typeText("test")
                    device.uiDevice.click(950, 1700)
                }

                step("Проверям что отрисовалось") {
                    TasksListScreen {
                        tasksRV {
                            hasDescendant { withText("test") }
                        }
                    }
                }
            }
        }
    }
}

/* todo
причесать кейсы

проверить валидацию поля ввода циклом с пробросом значений    на rename



getText считывает видимое содержимое
 */


