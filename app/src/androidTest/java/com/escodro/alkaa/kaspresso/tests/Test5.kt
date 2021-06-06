package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.CalendarScreen
import com.escodro.alkaa.kaspresso.screens.TaskDetailsScreen
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Test

class Test5 : BaseTestCase() {
/*

*/

    @Test
    fun test5() {
        launch().run {


        scenario(AddTaskScenario("test5"))


            step("открываем таску"){
                TasksListScreen.tasksRV.childAt<TasksListScreen.Task>(0){
                    click()
                }

            }

            step("Устанавливаем время"){
                TaskDetailsScreen {
                   setAlarm.click()
                }
                CalendarScreen {
                    datePicker.setDate(2021,5,15)
                    okButton.click()
                    timePicker.setTime(12,22)
                    okButton.click()
                }
            }


        }
    }
}