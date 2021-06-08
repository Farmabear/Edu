package com.escodro.alkaa.kaspresso.tests


import com.agoda.kakao.common.views.KView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.*
import org.junit.Test

class Test5 : BaseTestCase() {
/*

*/

    @Test
    fun test5() {
        launch().run {


            scenario(AddTaskScenario("test5"))


            step("открываем таску") {
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0) {
                    click()
                }

            }

            step("Устанавливаем время") {
                TaskDetailsScreen {

                    alarmDate {
                        hasText("Add an alarm")
                        isDisplayed()
                    }
                    setAlarm.click()
                    CalendarScreen {
                        datePicker.setDate(2021, 5, 15)
                        okButton.click()
                        timePicker.setTime(12, 22)
                        okButton.click()
                    }
                    KView {
                        isDescendantOfA { withId(R.id.fragment_taskdetail_alarm) }
                        withoutText("Add an alarm")
                    }.isDisplayed()
                }


            }

        }


    }
}
//
//    /**
//     * @see <a href="https://testrail/index.php?/cases/view/">
//     *
//     * </a>
//     */
//    @Test
//    fun checkPosition() {
//        launch().run {
//            ToolbarScreen{
//                back.click()
//            }
//            MenuScreen {
//                KTextView {
//                    withIndex(1){
//                        withId(R.id.design_menu_item_text)
//                    }
//                }.hasText("Personal")
//            }
//        }
//    }
