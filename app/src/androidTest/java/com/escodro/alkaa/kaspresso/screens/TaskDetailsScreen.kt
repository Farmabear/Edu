package com.escodro.alkaa.kaspresso.screens
import androidx.fragment.app.Fragment
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.scroll.KScrollView
import com.agoda.kakao.text.KButton
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen


object TaskDetailsScreen : BaseScreen<TaskDetailsScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    val taskname = KEditText() { withId(R.id.edittext_taskdetail_title) }

    val taskGroup = KScrollView { withId(R.id.scrollview_taskdetail_category) }

    val setAlarm  = KButton {withId(R.id.btn_taskdetail_date)}
    }









