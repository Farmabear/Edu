package com.escodro.alkaa.kaspresso.tests


import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.espresso.action.ViewActions.click
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddCategoryScenario
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.*
import com.escodro.alkaa.kaspresso.screens.CategoriesScreen.addCatButt
import org.junit.Test

class Test4 : BaseTestCase() {
/*

*/

    @Test
    fun test4() {
        launch().run {


            step("Вызываем Меню") {
                scenario(AddCategoryScenario("AutoGreenCat", "Green"))
            }

            step("Создаем таску и проваливаемся в нее") {
                scenario(AddTaskScenario("Green"))
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    click()
                }
                step("Присваиваем созданную категорию") {
                    TaskDetailsScreen {
                        KView {
                            isDescendantOfA { withId(R.id.scrollview_taskdetail_category) }
                            withText("AutoGreenCat")
                        }.click()
                        Screen.idle(5000)
                    }

                }

            }
        }
    }
}

