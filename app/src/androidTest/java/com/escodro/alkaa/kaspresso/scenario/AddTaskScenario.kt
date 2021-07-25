package com.escodro.alkaa.kaspresso.scenario

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.screen.Screen.Companion.idle
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class AddTaskScenario(
        private val text: String,
        private val categ: String = ""
) : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        val initRvSize = TasksListScreen.tasksRV.getSize()

        step("Делайм свайп вверх, кликаем на поле добавления таски и вводим  \"$text\"") {
            Espresso.onView(isRoot()).perform(ViewActions.swipeUp())
            TasksListScreen {
                tasksRV.lastChild<TasksListScreen.AddTask> {
                    descriptionET {
                        click()
                        typeText(text)
                    }
                    device.uiDevice.click(950, 1700)
                }

//                while (initRvSize == tasksRV.getSize()) {
//                    idle(100)
//                }             //!!попробовать средствами isdisplayed iscomplytlelydisplayed
                //findelemnt чайлда с сиблинга с текстом и проверка на издисплев
            }
        }

        step("Проверяем, что созданная таска внизу списка и имеет текст $text") {
            TasksListScreen {
                //idle(2000)  // какое изящное решение для презапроса размера ? без идла получает неправильный рамер
                tasksRV.childAt<TasksListScreen.Task>(tasksRV.getSize() - 2) {
                    taskName {
                        hasText(text)
                        isDisplayed()
                    }
                }
            }
        }

        if (categ.isNotEmpty()) {
            step("Кликаем на последнюю созданную таску") {
                TasksListScreen {
                    tasksRV.childAt<TasksListScreen.Task>(tasksRV.getSize() - 2) {
                        taskName.click()
                    }
                }
            }

            step("Присваиваем категорию \"$categ\"") {
                TaskDetailsScreen {
                    KView {
                        isDescendantOfA { withId(R.id.scrollview_taskdetail_category) }
                        withText("$categ")
                    }.click()
                }
            }

            step("Возвращаемся назад  и проверяем e последней созданной таски цвет бейджа и текст") {
                ToolbarScreen {
                    back.click()
                }
                TasksListScreen {
                    tasksRV.childAt<TasksListScreen.Task>(tasksRV.getSize() - 2) {
                        taskColor.hasBackgroundColor(R.color.pink)  //продумать как пробрасывать чек цвета в зависимости от данных                            // сценрия
                        taskName.hasText(text)
                    }
                }
            }
        }
    }
}
