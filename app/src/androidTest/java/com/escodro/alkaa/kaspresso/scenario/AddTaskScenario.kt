package com.escodro.alkaa.kaspresso.scenario

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.*
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.screen.Screen
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class AddTaskScenario(
        private val text: String,
        private val categ: String? = null
) : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        TasksListScreen {
            step("Setting Task with name \"$text\"") {
                //descriptionET.isVisible()
                descriptionET.scrollTo()
                descriptionET.typeText(text)
                device.uiDevice.click(950, 1700)
            }

            step("Проверям что отрисовалось") {
                TasksListScreen {
                    tasksRV {
                        hasDescendant { withText("$text") }
                    }
                }
            }

            if (categ != null) {
                step("проваливаемся в таску\"$text\"") {

                    TasksListScreen {
                        tasksRV.childWith<TasksListScreen.Task> {
                            withDescendant {
                                withText("$text")
                            }
                        } perform {
                            taskName {
                                isDisplayed()
                                hasText("$text")
                                click()
                            }
                        }
                    }
                }

                step("Присваиваем категорию \"$categ\"") {

                    TaskDetailsScreen {
                        KView {
                            isDescendantOfA { withId(R.id.scrollview_taskdetail_category) }
                            withText("$categ")
                        }.click()
                        // Screen.idle(5000)
                    }
                }

                step("возвращаемся в корень") {

                    ToolbarScreen {
                        back.click()
                    }
                }
            }
        }
    }
}
