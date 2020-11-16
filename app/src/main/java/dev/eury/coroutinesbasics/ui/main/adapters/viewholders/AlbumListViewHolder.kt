package dev.eury.coroutinesbasics.ui.main.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.AlbumListItem
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction
import dev.eury.coroutinesbasics.ui.main.adapters.albums.AlbumAdapter

class AlbumListViewHolder(view: View, val onAction:(MainScreenItemAction) -> Unit) : BaseViewHolder<AlbumListItem>(view) {

    private val recyclerView = view.findViewById<RecyclerView>(R.id.rv_data)

    private val adapter = AlbumAdapter(onAction)

    init {
        recyclerView.adapter = adapter
    }

    override fun bind(item: AlbumListItem) {
        adapter.items = item.albums
    }
}