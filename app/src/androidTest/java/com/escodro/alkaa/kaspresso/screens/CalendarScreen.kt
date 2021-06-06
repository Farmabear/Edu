package com.escodro.alkaa.kaspresso.screens

import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import com.agoda.kakao.picker.date.KDatePicker
import com.agoda.kakao.picker.time.KTimePicker
import com.agoda.kakao.text.KButton
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen

object CalendarScreen : BaseScreen<CalendarScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    val datePicker = KDatePicker {isInstanceOf(DatePicker::class.java) }
    val timePicker = KTimePicker {isInstanceOf(TimePicker::class.java)}
    val okButton = KButton {withId(android.R.id.button1)}
}
