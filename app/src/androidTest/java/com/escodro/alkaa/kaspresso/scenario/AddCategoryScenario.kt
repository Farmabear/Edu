package com.escodro.alkaa.kaspresso.scenario

import com.escodro.alkaa.kaspresso.screens.*
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class AddCategoryScenario(
        catName: String, catСolor: String
) : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {

        step("Вызываем Меню и выбираем категорию Manage categories") {
            ToolbarScreen {
                back.click()
            }
            MenuScreen {
                selectMenuItem("Manage categories")
            }
        }

        step("Нажимаем добавить категорию") {
            CategoriesScreen {
                addCatButt.click()
            }
        }

        step("Добавляем $catName категорию и красим в $catСolor") {
            CategoryAddScreen {
                catNameInput.typeText("$catName")

                when (catСolor.toLowerCase()) {
                    "blue" -> catFlagBlue.click()
                    "green" -> catFlagGreen.click()
                    "purple" -> catFlagPurple.click()
                    "pink" -> catFlagPink.click()
                    "red" -> catFlagRed.click()
                    "orange" -> catFlagOrange.click()
                    "yellow" -> catFlagYellow.click()
                }
                catSaveButton.click()
            }
            ToolbarScreen { back.click() }
        }
    }
}
