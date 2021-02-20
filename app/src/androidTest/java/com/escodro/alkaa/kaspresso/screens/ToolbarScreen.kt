package com.escodro.alkaa.kaspresso.screens

import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen

object ToolbarScreen : BaseScreen<ToolbarScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    val menuButton = KImageView {
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val title = KTextView { withId(R.id.toolbar_title) }
}