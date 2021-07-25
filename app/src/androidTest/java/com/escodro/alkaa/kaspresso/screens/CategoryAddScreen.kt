package com.escodro.alkaa.kaspresso.screens

import androidx.fragment.app.Fragment
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KButton
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen


object CategoryAddScreen : BaseScreen<CategoryAddScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    val catNameInput = KEditText { withId(R.id.edittext_categorynew_description) }
    val catFlagBlue = KButton { withId(R.id.radiobutton_categorynew_blue) }
    val catFlagGreen = KButton { withId(R.id.radiobutton_categorynew_green) }
    val catFlagPurple = KButton { withId(R.id.radiobutton_categorynew_purple) }
    val catFlagPink = KButton { withId(R.id.radiobutton_categorynew_pink) }
    val catFlagRed = KButton { withId(R.id.radiobutton_categorynew_red) }
    val catFlagOrange = KButton { withId(R.id.radiobutton_categorynew_orange) }
    val catFlagYellow = KButton { withId(R.id.radiobutton_categorynew_yellow) }

    val catSaveButton = KButton { withId(R.id.button_categorynew_add) }
}
