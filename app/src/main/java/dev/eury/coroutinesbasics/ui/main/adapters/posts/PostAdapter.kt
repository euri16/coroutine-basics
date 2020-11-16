package dev.eury.coroutinesbasics.ui.main.adapters.posts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction
import dev.eury.coroutinesbasics.utils.inflate

class PostAdapter(private val onAction:(MainScreenItemAction) -> Unit) : RecyclerView.Adapter<PostViewHolder>() {

    var items: List<Post> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(parent.inflate(R.layout.itv_post), onAction)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()
}