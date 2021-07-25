package com.escodro.alkaa.kaspresso.screens

import androidx.fragment.app.Fragment
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.kaspresso.base.BaseScreen
import com.escodro.navigation.R

object MenuScreen : BaseScreen<MenuScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    /**
     * Выбирает пункт в боковом выезжающем меню
     */
    fun selectMenuItem(itemText: String) {
        KTextView {
            withId(R.id.design_menu_item_text)
            withText(itemText)
        }.click()
    }
}
