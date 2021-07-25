package com.escodro.alkaa.kaspresso.screens

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object KeyboardUiScreen : UiScreen<KeyboardUiScreen>() {

    override val packageName = "com.android.jajaja"

    val addButton = UiButton {
        withId(this@KeyboardUiScreen.packageName, "iygewgyfew")
    }
}
