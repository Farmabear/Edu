package com.escodro.alkaa.kaspresso.tests


import com.agoda.kakao.common.views.KView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddCategoryScenario
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.*
import org.junit.Test

class TaskCategoriesTests : BaseTestCase() {

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test4.kt">
     * Бывший test4:
     * тест на создание и присвоении категории таске
     */
    @Test
    fun assignCategoryAfterCreation() {
        launch().run {
            val testColor = "green"
            val name = testColor + "task"

            scenario(AddCategoryScenario("$testColor cat", testColor))
            scenario(AddTaskScenario(name))

            step("Проверяем в созданной таске текст = '$name' и открываем её") {
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskName {
                                hasText(name)
                                isDisplayed()
                            }
                            click()
                        }
                    }
                }
            }

            step("Присваиваем созданную категорию") {
                TaskDetailsScreen {
                    KView {
                        isDescendantOfA { withId(R.id.scrollview_taskdetail_category) }
                        withText("$testColor cat")
                    }.perform {
                        click()
                    }
                }
            }

            step("Возвращаемся назад и проверяем цвет бейджа и текст") {
                ToolbarScreen {
                    back.click()
                }
                TasksListScreen {
                    tasksRV {
                        firstChild<TasksListScreen.Task> {
                            taskColor.hasBackgroundColor(R.color.green)
                            taskName.hasText(name)
                        }
                    }
                }
            }
        }
    }

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test6.kt">
     * Бывший test6:
     * тест на создание 10 тасок (2 простых и 3 в категории), создание категории
     * и проверка фильтрации по категории
     */
    @Test
    fun filtrationOfCreatedTasks() {
        launch().run {
            val numOfSimple = 3
            val numOfCat = 3
            val catName = "Pink"
            val catColor = "pink"
            val colorTaskName = "\"$catName\"task"

            step("Создаем $numOfSimple простых тасок Без категорий") {
                repeat(numOfSimple) { scenario(AddTaskScenario("Simple")) }
            }

            step("Cоздаем категорию с именем $catName и цветом $catColor") {
                scenario(AddCategoryScenario(catName, catColor))
            }

            step("Cоздаем $numOfCat таски c шаблоном имени $colorTaskName  в категории $catName") {
                for (i in 1..numOfCat) {
                    scenario(AddTaskScenario("$colorTaskName$i", catName))
                }
            }

            step("Вызываем боковое меню и выбираем категорию $catName ") {
                ToolbarScreen {
                    back.click()
                }
                MenuScreen {
                    selectMenuItem(catName)
                }
            }

            step("Проверям, что таски содержат $colorTaskName и имеет цвет бейджа категории") {
                TasksListScreen {
                    for (position in 0 until tasksRV.getSize() - 1) {
                        tasksRV.childAt<TasksListScreen.Task>(position) {
                            taskColor.hasBackgroundColor(R.color.pink)
                            taskName.containsText(colorTaskName)
                        }
                    }
                }
            }

//            KeyboardUiScreen{
//                addButton            //доразобратся с вызовом элемента другого приложения (путь искаьт через UI automator)
//            }
        }
    }
}
