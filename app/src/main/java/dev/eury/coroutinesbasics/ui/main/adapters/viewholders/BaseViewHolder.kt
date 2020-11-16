package dev.eury.coroutinesbasics.ui.main.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenListItem

abstract class BaseViewHolder<T : MainScreenListItem>(view: View)
    : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T)
}