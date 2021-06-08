package com.escodro.alkaa.kaspresso.tests


import androidx.appcompat.widget.AppCompatImageButton
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test

class Test3 : BaseTestCase() {
/*

*/

    @Test
    fun test3() {
        launch().run {


            scenario(AddTaskScenario("test3"))


            step("открываем таску") {
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    click()
                }

            }

            step("меняем имя и назад в корень ") {
                TaskDetailsScreen {
                    taskname.clearText()
                    taskname.typeText("new")
                }
                ToolbarScreen {
                    back.click()
                }
            }
            step("тмечаем таску как готовую") {
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    taskCheckBox.click()
                }
            }

        }
    }
}