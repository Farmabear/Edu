package com.escodro.alkaa.kaspresso.screens
import androidx.fragment.app.Fragment
import com.agoda.kakao.edit.KEditText
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen


object TaskDetailsScreen : BaseScreen<TaskDetailsScreen>() {
    override val layout = R.layout.fragment_task_detail
    override val fragment = Fragment::class

    val taskname = KEditText() { withId(R.id.edittext_taskdetail_title)

}
}