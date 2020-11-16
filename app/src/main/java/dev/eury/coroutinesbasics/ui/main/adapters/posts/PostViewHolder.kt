package dev.eury.coroutinesbasics.ui.main.adapters.posts

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.ui.main.adapters.PostClickedAction

class PostViewHolder(val view: View, val onAction:(PostClickedAction) -> Unit) : RecyclerView.ViewHolder(view) {

    private val tvPostTitle = view.findViewById<TextView>(R.id.tv_post_title)
    private val tvPostContent = view.findViewById<TextView>(R.id.tv_post_body)

    fun bind(item: Post) {
        tvPostTitle.text = item.title
        tvPostContent.text = item.body

        //TODO: move to init
        view.setOnClickListener {
            onAction(PostClickedAction(item))
        }
    }
}