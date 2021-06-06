package com.escodro.alkaa.kaspresso.screens

import android.view.View
import androidx.fragment.app.Fragment
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.edit.KTextInputLayout

import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen
import org.hamcrest.Matcher


object CategoryAddScreen : BaseScreen<CategoryAddScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    val catNameinput = KEditText({ withId(R.id.edittext_categorynew_description) })

    val catflagBlue = KButton{withId(R.id.radiobutton_categorynew_blue)}
    val catflagGreen = KButton{withId(R.id.radiobutton_categorynew_green)}
    val catflagPurple = KButton{withId(R.id.radiobutton_categorynew_purple)}
    val catflagPink = KButton{withId(R.id.radiobutton_categorynew_pink)}
    val catflagRed = KButton{withId(R.id.radiobutton_categorynew_red)}
    val catflagOrange = KButton{withId(R.id.radiobutton_categorynew_orange)}
    val catflagYellow = KButton{withId(R.id.radiobutton_categorynew_yellow)}



    val catsaveButton = KButton{withId(R.id.button_categorynew_add)}

}