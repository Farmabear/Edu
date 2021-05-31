package com.escodro.alkaa.kaspresso.tests


import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.TasksListScreen
import org.junit.Test

class Test2 : BaseTestCase() {
/*

*/

    @Test
    fun test1() {
        launch().run {
        scenario(AddTaskScenario("test2"))


            step("меняем название таски"){

            }

            step("Проверяем что отображается новое название"){

            }

        }


    }
}