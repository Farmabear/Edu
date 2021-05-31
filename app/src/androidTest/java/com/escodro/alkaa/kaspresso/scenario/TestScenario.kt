package com.escodro.alkaa.kaspresso.scenario

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class TestScenario() : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        step("gffjyh") {
            TasksListScreen{
                tasksRV.isVisible()
            }
        }
        step("") {
            TasksListScreen{
                tasksRV.isVisible()
                device.keyboard.sendEvent()
            }
        }
        TasksListScreen{
            tasksRV.isVisible()
        }
        TasksListScreen{
            tasksRV.isVisible()
        }
    }
}
