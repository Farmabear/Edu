package com.escodro.alkaa.kaspresso.tests


import androidx.appcompat.widget.AppCompatImageButton
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseTestCase
import com.escodro.alkaa.kaspresso.scenario.AddTaskScenario
import com.escodro.alkaa.kaspresso.screens.*
import com.escodro.alkaa.kaspresso.screens.CategoriesScreen.addCatButt
import org.junit.Test

class Test4 : BaseTestCase() {
/*

*/

@Test
fun test1() {
    launch().run {


        step("Вызываем Меню") {
            ToolbarScreen {
                back.click()
            }
        }

        step("Вызываем Меню") {
            MenuScreen {
                selectMenuItem("Manage categories")
            }
        }

        step ("добавляем категорию"){
            CategoriesScreen {
                addCatButt.click()
            }

        }


    }
}


}

