package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.CalendarScreen
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test

class TasklistScreenTests : BaseTestCase() {

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test1.kt">
     * Бывший test1:
     * тест на создание и переименование созданного задания
     */

    @Test
    fun renameAfterTaskCreation() {
        launch().run {
            scenario(AddTaskScenario("test2"))

            step("открываем таску"){
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0){
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

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test2_2.kt">
     * Бывший test2_2:
     * тест на изменение имени созданной таски по массиву значегтй
     */
    @Test
    fun renameAfterCreationWithListOfNames() {
        launch().run {
            val list = listOf(
                    "fds",
                    "dsf",
                    "dsfffffffffffffffffffffffffffffffdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddffffffffsdfffffffffff",
                    "@sdfdsf"
            )
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

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test3.kt">
     * Бывший test3:
     * тест на создание и отметку таски как готовой
     */
    @Test
    fun SettingDoneOfCreatedTask() {
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

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test5.kt">
     * Бывший test5:
     * тест на создание и установку напоминания для таски
     */
    @Test
    fun SetAlarmForCreatedTask() {
        launch().run {
            scenario(AddTaskScenario("test5"))

            step("открываем таску") {
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    click()
                }
            }

            step("Устанавливаем время") {
                TaskDetailsScreen {
                    alarmDate {
                        hasText("Add an alarm")
                        isDisplayed()
                    }
                    setAlarm.click()
                    CalendarScreen {
                        datePicker.setDate(2021, 5, 15)
                        okButton.click()
                        timePicker.setTime(12, 22)
                        okButton.click()
                    }
                    alarmDate.isInvisible()
                }
            }
        }
    }
















}
