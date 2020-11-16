package dev.eury.coroutinesbasics.ui.main.adapters.albums

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction
import dev.eury.coroutinesbasics.utils.inflate

class AlbumAdapter(val onAction:(MainScreenItemAction) -> Unit) : RecyclerView.Adapter<AlbumViewHolder>() {

    var items: List<Album> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(parent.inflate(R.layout.itv_album), onAction)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()
}