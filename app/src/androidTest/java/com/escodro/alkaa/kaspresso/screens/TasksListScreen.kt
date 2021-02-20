package com.escodro.alkaa.kaspresso.screens

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen
import com.escodro.task.presentation.list.TaskListFragment
import org.hamcrest.Matcher


object TasksListScreen : BaseScreen<TasksListScreen>() {
    override val layout = R.layout.fragment_task_list
    override val fragment = TaskListFragment::class

    val tasksRV = KRecyclerView({ withId(R.id.recyclerview_tasklist_list) }) {
        itemType(::AddTask)
    }

    class AddTask(parent: Matcher<View>) : KRecyclerItem<AddTask>(parent) {
        val descriptionET = KEditText(parent) { withId(R.id.edittext_itemadd_description) }
        val plusIV = KImageView(parent) { withId(R.id.imageview_itemadd_completed) }
    }
}