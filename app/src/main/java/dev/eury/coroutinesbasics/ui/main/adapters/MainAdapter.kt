package dev.eury.coroutinesbasics.ui.main.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.viewholders.*
import dev.eury.coroutinesbasics.utils.inflate

class MainAdapter(private val onAction: (MainScreenItemAction) -> Unit) :
    RecyclerView.Adapter<BaseViewHolder<MainScreenListItem>>() {

    var items: List<MainScreenListItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (ItemType.values()[viewType]) {
            ItemType.CREATE_POST -> CreatePostViewHolder(parent.inflate(R.layout.itv_create_post), onAction)
            ItemType.TITLE -> TitleViewHolder(parent.inflate(R.layout.itv_title), onAction)
            ItemType.ALBUM -> AlbumListViewHolder(parent.inflate(R.layout.itv_hrz_recyclerview), onAction)
            ItemType.TODOs -> TodoListViewHolder(parent.inflate(R.layout.itv_hrz_recyclerview))
            ItemType.POSTS -> PostListViewHolder(parent.inflate(R.layout.itv_vert_recyclerview), onAction)
        } as BaseViewHolder<MainScreenListItem>

    override fun onBindViewHolder(holder: BaseViewHolder<MainScreenListItem>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()
}