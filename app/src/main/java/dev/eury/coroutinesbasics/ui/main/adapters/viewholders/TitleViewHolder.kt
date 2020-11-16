package dev.eury.coroutinesbasics.ui.main.adapters.viewholders

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.*

class TitleViewHolder(view: View, val onAction:(MainScreenItemAction) -> Unit) : BaseViewHolder<TitleListItem>(view) {

    private val tvTitle = view.findViewById<TextView>(R.id.tv_todos_title)
    private val tvSeeAll = view.findViewById<View>(R.id.tv_todos_see_all)

    override fun bind(item: TitleListItem) {
        tvTitle.text = item.title
        tvSeeAll.isVisible = item.isSeeAllVisible

        //TODO move to init
        tvSeeAll.setOnClickListener {
            onAction(SeeAllAction(item.itemType))
        }
    }
}