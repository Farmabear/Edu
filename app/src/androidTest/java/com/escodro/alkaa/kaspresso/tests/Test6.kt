package com.escodro.alkaa.kaspresso.tests


import android.view.View
import android.widget.EditText
import androidx.test.espresso.intent.Checks
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddCategoryScenario
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.MenuScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import com.escodro.alkaa.kaspresso.screens.ToolbarScreen
import org.hamcrest.Matchers.containsString
import org.junit.Test
import java.util.regex.Matcher


class Test6 : BaseTestCase() {
/*

*/

    @Test
    fun test6() {
        launch().run {

            step("Создаем 7 простых тасок") {
                repeat(7) { scenario(AddTaskScenario("Green")) }
            }
            step("создаем категорию Pink") {
                scenario(AddCategoryScenario("pink", "pink"))
            }

            step("создаем 3 таски в категории Pink") {
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

/*есть подозрение что при таком подходе чекаются не все элементы*/
            step("Проверям что таски содержат pinktask ") {
                TasksListScreen {
                    tasksRV {
                        hasDescendant {
                            isDisplayed()
                            containsText("pinktask") }
                    }
                }
            }





//
//            step("Проверяем что у видимых  тасок есть есть текст pinktask") {
//                TasksListScreen {
//                    tasksRV.childWith<TasksListScreen.Task> {
//                        withDescendant {
//                            withId(R.id.textview_itemtask_description)
//                            isVisible()
//
//                        }
//                    } perform {
//                        taskName {
//                            isDisplayed()
//                            containsText("pinktask")
//                        }
//                    }
//                }


//            step("Проверяем что у всех тасок есть розовые бейджи") {
//                TasksListScreen {
//                    tasksRV.children<TasksListScreen.Task> {
//                        withChild(withId(R.id.view_itemtask_color))
//                    }color matcher ?
//
//
//                }
//
//
//            }
            }
        }
    }




