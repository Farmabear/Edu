package com.escodro.alkaa.kaspresso.scenario

import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class AddTaskScenario(
        private val text: String
) : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        TasksListScreen {
            tasksRV.childAt<TasksListScreen.AddTask>(0) {
                step("Setting Task with name \"$text\"") {

                    descriptionET.typeText(text)
                }
                device.uiDevice.pressEnter()
            }
        }
    }
}