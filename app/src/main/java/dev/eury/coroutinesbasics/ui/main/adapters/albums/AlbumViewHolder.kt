package dev.eury.coroutinesbasics.ui.main.adapters.albums

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.ui.main.adapters.AlbumClickedAction
import dev.eury.coroutinesbasics.utils.loadImage

class AlbumViewHolder(view: View, val onAction:(AlbumClickedAction) -> Unit) : RecyclerView.ViewHolder(view) {

    private val imageView = view.findViewById<ImageView>(R.id.iv_album)

    fun bind(item: Album) {
        imageView.loadImage(item.thumbnail)

        //TODO move to init
        imageView.setOnClickListener{
            onAction(AlbumClickedAction(item))
        }
    }
}