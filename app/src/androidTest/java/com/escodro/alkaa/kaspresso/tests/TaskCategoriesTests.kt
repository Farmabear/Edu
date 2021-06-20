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
    fun AssignCategoryAfterCreation() {
        launch().run {

            step("Вызываем Меню") {
                scenario(AddCategoryScenario("AutoGreenCat", "Green"))
            }

            step("Создаем таску и проваливаемся в нее") {
                scenario(AddTaskScenario("Green"))
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    click()
                    // testLogger.d()
                }
            }

            step("Присваиваем созданную категорию") {
                TaskDetailsScreen {
                    KView {
                        isDescendantOfA { withId(R.id.scrollview_taskdetail_category) }
                        withText("AutoGreenCat")
                    }.click()
                    //Screen.idle(5000)
                }
            }
        }
    }

    /**
     * @see </src/androidTest/java/com/escodro/alkaa/kaspresso/tests/Test6.kt">
     * Бывший test6:
     * тест на создание 10 тасок (7 простых и 3 в категории), создание категории
     * и проверка фильтрации по категории
     */
    @Test
    fun filtrationOfCreatedTasks() {
        launch().run {

            step("Создаем 7 простых тасок") {
                repeat(5) { scenario(AddTaskScenario("Green")) }
            }

            step("Cоздаем категорию Pink") {
                scenario(AddCategoryScenario("pink", "pink"))
            }

            step("Cоздаем 3 таски в категории Pink") {
                for (i in 1..3) {
                    scenario(AddTaskScenario("pinktask$i", "pink"))
                }
            }

            step("выбираем категорию pink") {
                ToolbarScreen {
                    back.click()
                }
                MenuScreen {
                    selectMenuItem("pink")
                }
            }

            step("Проверям что таски содержат pinktask ") {
                TasksListScreen {
                    for (position in 0 until tasksRV.getSize() - 1) {
                        tasksRV.childAt<TasksListScreen.Task>(position) {
                            taskColor.hasBackgroundColor(R.color.pink)
                            taskName.containsText("pinktask")
                        }
                    }
                }
            }
        }
    }
}