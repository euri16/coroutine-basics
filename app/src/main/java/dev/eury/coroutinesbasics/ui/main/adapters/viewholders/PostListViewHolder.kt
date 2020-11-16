package dev.eury.coroutinesbasics.ui.main.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction
import dev.eury.coroutinesbasics.ui.main.adapters.PostsListItem
import dev.eury.coroutinesbasics.ui.main.adapters.posts.PostAdapter

class PostListViewHolder(view: View, val onAction:(MainScreenItemAction) -> Unit) : BaseViewHolder<PostsListItem>(view) {

    private val recyclerView = view.findViewById<RecyclerView>(R.id.rv_data)

    private val adapter = PostAdapter(onAction)

    init {
        recyclerView.adapter = adapter
    }

    override fun bind(item: PostsListItem) {
        adapter.items = item.posts
    }
}