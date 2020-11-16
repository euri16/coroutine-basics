package dev.eury.coroutinesbasics.ui.main.adapters.viewholders

import android.view.View
import dev.eury.coroutinesbasics.ui.main.adapters.CreatePostClickedAction
import dev.eury.coroutinesbasics.ui.main.adapters.CreatePostListItem
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction

class CreatePostViewHolder(view: View, onAction:(MainScreenItemAction) -> Unit) : BaseViewHolder<CreatePostListItem>(view) {

    init {
        view.setOnClickListener {
            onAction(CreatePostClickedAction)
        }
    }

    override fun bind(item: CreatePostListItem) {}
}