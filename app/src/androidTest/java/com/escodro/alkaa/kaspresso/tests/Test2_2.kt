package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.getText
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Assert
import org.junit.Test

class Test2_2 : BaseTestCase() {
/*

*/

    @Test
    fun test2_2() {
        val list = listOf(
                "fds",
                "dsf",
                "dsfffffffffffffffffffffffffffffffdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddffffffffsdfffffffffff",
                "@sdfdsf"
        )

        launch().run {


            scenario(AddTaskScenario("test2"))


            step("открываем таску") {
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    click()
                }

            }

            step("Прогон списка занчений") {
                TaskDetailsScreen {
                    list.forEach {
                        taskname {
                            replaceText(it)
                            hasText(it)
                        }
                    }
                }
            }
        }
    }
}