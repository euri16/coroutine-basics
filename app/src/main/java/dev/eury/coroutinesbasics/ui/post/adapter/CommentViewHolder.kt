package dev.eury.coroutinesbasics.ui.post.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.ui.main.adapters.PostClickedAction

class CommentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val tvUsername = view.findViewById<TextView>(R.id.tv_name)
    private val tvEmail = view.findViewById<TextView>(R.id.tv_email)
    private val tvBody = view.findViewById<TextView>(R.id.tv_post_body)

    fun bind(item: Comment) {
        tvUsername.text = item.name
        tvEmail.text = item.email
        tvBody.text = item.body
    }
}