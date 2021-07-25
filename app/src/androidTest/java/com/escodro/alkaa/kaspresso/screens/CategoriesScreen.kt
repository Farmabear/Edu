package com.escodro.alkaa.kaspresso.screens

import android.view.View
import androidx.fragment.app.Fragment
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.escodro.alkaa.R
import com.escodro.alkaa.kaspresso.base.BaseScreen
import org.hamcrest.Matcher


object CategoriesScreen : BaseScreen<CategoriesScreen>() {
    override val layout = 0
    override val fragment = Fragment::class

    val categRV = KRecyclerView({ withId(R.id.recyclerview_categorylist_list) }) {

        itemType(::Category)
    }

    class Category(parent: Matcher<View>) : KRecyclerItem<KRecyclerView>(parent) {

        val threeDots = KButton(parent) { withId(R.id.imageview_itemcategory_options) }
        val categName = KTextView(parent) { withId(R.id.textview_itemcategory_description) }
    }

    val addCatButt = KButton { withId(R.id.button_categorylist_add) }
}
