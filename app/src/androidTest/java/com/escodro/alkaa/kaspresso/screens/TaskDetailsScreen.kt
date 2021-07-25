package com.escodro.alkaa.kaspresso.screens

import com.agoda.kakao.common.views.KView
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.scroll.KScrollView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen
import com.escodro.task.presentation.detail.main.TaskDetailFragment


object TaskDetailsScreen : BaseScreen<TaskDetailsScreen>() {
    override val layout = R.layout.fragment_task_detail
    override val fragment = TaskDetailFragment::class

    val taskName = KEditText { withId(R.id.edittext_taskdetail_title) }
    val taskGroup = KScrollView { withId(R.id.scrollview_taskdetail_category) }
    val setAlarm = KButton { withId(R.id.btn_taskdetail_date) }
    val alarmDate = KTextView { withId(R.id.textview_taskdetail_date) }
    val alarmChip = KTextView { withId(R.id.chip_taskdetail_date) }
    val catChip = KView { isDescendantOfA { withId(R.id.scrollview_taskdetail_category) } }
    val alarmDateSet = KView { isDescendantOfA { withId(R.id.fragment_taskdetail_alarm) } }
}
