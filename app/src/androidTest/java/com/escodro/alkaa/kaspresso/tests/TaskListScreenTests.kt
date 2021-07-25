package com.escodro.alkaa.kaspresso.tests

import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.base.listOfNames
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.CalendarScreen
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.junit.Test

class TaskListScreenTests : BaseTestCase() {

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test1.kt">
     * Бывший test1:
     * тест на создание и переименование созданного задания
     */
    @Test
    fun renameAfterTaskCreation() {
        launch().run {
            val initTaskName = "Test1"
            val newTaskName = "New"

            scenario(AddTaskScenario(initTaskName))

            step("Убиваем приложение и запускаем его снова (не делая ресет)") {
                restart()
            }

            step("Проверяем в созданной таске текст, видимость и открываем её") {
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText(initTaskName)
                                isDisplayed()
                            }
                            click()
                        }
                    }
                }
            }

            step("Проверяем имя и отображение имени таски $initTaskName") {
                TaskDetailsScreen {
                    taskName {
                        isDisplayed()
                        hasText(initTaskName)
                    }
                }
            }

            step("Меняем имя таски с $initTaskName на $newTaskName, проверяем что поле приняло значение") {
                TaskDetailsScreen {
                    taskName {
                        replaceText(newTaskName)
                        hasText(newTaskName)
                    }
                }
            }

            step("Нажимаем назад и проверяем что таска имеет имя $newTaskName") {
                TasksListScreen {
                    pressBack()
                    tasksRV {
                        hasSize(2)
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText(newTaskName)
                                isDisplayed()
                            }
                        }
                    }
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
            val initTaskName = "Test2"

            scenario(AddTaskScenario(initTaskName))

            step("Проверяем в созданной таске текст, видимость и открываем её") {
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText(initTaskName)
                                isDisplayed()
                            }
                            click()
                        }
                    }
                }
            }

            step("Переименовывание таски именами из списка (проверка на прием полем различнх имен") {
                TaskDetailsScreen {
                    taskName {
                        hasText(initTaskName)
                        listOfNames.forEach { name ->
                            testLogger.i(" REPLACING WITH $name ")
                            replaceText(name)                                     //!!переименование листа - прочитать рекомендации JB
                            hasText(name)
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
    fun settingDoneOfCreatedTask() {
        launch().run {
            val initTaskName = "Test3"
            val newTaskName = "New"

            scenario(AddTaskScenario(initTaskName))

            step("Проверяем в созданной таске текст, видимость и открываем её") {
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText(initTaskName)
                                isDisplayed()
                            }
                            click()
                        }
                    }
                }
            }

            step("Меняем имя c $initTaskName на $newTaskName и нажимаем назад") {
                TaskDetailsScreen {
                    taskName {
                        hasText(initTaskName)
                        replaceText(newTaskName)
                        hasText(newTaskName)
                    }
                }
                ToolbarScreen {
                    back.click()
                }
            }

            step("Нажимаем назад и проверяем что таска имеет имя $newTaskName") {
                TasksListScreen {
                    tasksRV {
                        hasSize(2)
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText(newTaskName)
                                isDisplayed()
                            }
                        }
                    }
                }
            }

            step("Отмечаем таску как готовую и проверяем что других тасок нет") {
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskCheckBox {
                                isDisplayed()
                                click()
                            }
                        }
                        hasSize(1)
                        lastChild<TasksListScreen.AddTask> {
                            descriptionET.hasHint("Add new task")
                        }
                    }
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
    fun setAlarmForCreatedTask() {
        launch().run {
            scenario(AddTaskScenario("test4"))

            step("Проверяем в созданной таске текст, видимость и открываем её") {
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText("test4")
                                isDisplayed()
                            }
                            click()
                        }
                    }
                }
            }

            step("Устанавливаем время будильника 2033-5-15 12:22 и проверяем отображение в чипе") {
                TaskDetailsScreen {
                    alarmDate {
                        hasText("Add an alarm")
                        isDisplayed()
                    }
                    setAlarm.click()
                    CalendarScreen {
                        datePicker.setDate(2033, 5, 15)
                        okButton.click()
                        timePicker.setTime(12, 22)
                        okButton.click()
                    }
                    alarmChip.hasText("May 15, 2033 12:22 PM")
                }
            }

            step("Нажимвем назад для возврата к списку тасок и проверяем дату будильника на таске") {
                ToolbarScreen {
                    back.click()
                }
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskAlarm.hasText("5/15/2033, 12:22 PM")
                        }
                    }
                }
            }
        }
    }

    private fun restart() {
        device.apps.kill("com.escodro.alkaa")
        device.apps.launch("com.escodro.alkaa")
    }
}
