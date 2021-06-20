package com.escodro.alkaa.kaspresso.tests.archive


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Test

class RenameTest : BaseTestCase() {

    @Test
    fun renameTask() {
        launch().run {


            scenario(AddTaskScenario("test2"))


            step("открываем таску") {
                TasksListScreen {
                    tasksRV.childWith<TasksListScreen.Task> {
                        withDescendant {
                            withText("test2")
                        }
                    } perform {
                        taskName {
                            isDisplayed()
                            hasText("test2")
                            click()
                        }
                    }
                }


            }

            step("меняем имя") {
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