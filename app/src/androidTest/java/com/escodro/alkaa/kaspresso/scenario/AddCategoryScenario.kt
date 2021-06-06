package com.escodro.alkaa.kaspresso.scenario

import com.escodro.alkaa.kaspresso.screens.*
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class AddCategoryScenario(
        private val catname: String,
        private val catcolor: String
) : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {

        step("Вызываем Меню и выбираем категортю Manage categories") {
            ToolbarScreen {
                back.click()
            }
            MenuScreen {
                selectMenuItem("Manage categories")
            }

        }


        step("добавляем категорию") {
            CategoriesScreen {
                addCatButt.click()
            }
        }

        step("добавляем $catname категорию и красим в $catcolor") {
            CategoryAddScreen {
                catNameinput.typeText("$catname")

                when (catcolor.toLowerCase()){
                    "blue" -> catflagBlue.click()
                    "green" -> catflagGreen.click()
                    "purple" -> catflagPurple.click()
                    "pink" -> catflagPink.click()
                    "red" -> catflagRed.click()
                    "orange" -> catflagOrange.click()
                    "yellow" -> catflagYellow.click()
                }
                catsaveButton.click()
            }
            ToolbarScreen { back.click() }
        }

    }
}
