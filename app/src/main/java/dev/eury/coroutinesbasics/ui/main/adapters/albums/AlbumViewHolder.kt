package dev.eury.coroutinesbasics.ui.main.adapters.albums

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.ui.main.adapters.AlbumClickedAction
import dev.eury.coroutinesbasics.utils.loadImage

class AlbumViewHolder(view: View, val onAction: (AlbumClickedAction) -> Unit) :
    RecyclerView.ViewHolder(view) {

    private val imageView = view.findViewById<ImageView>(R.id.iv_album)

    fun bind(item: Album) {
        imageView.loadImage(PICTURES.shuffled()[0])

        //TODO move to init
        imageView.setOnClickListener {
            onAction(AlbumClickedAction(item))
        }
    }

    companion object {
        val PICTURES = listOf(
            "https://images.unsplash.com/photo-1527080605226-28194980f1fc?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            "https://images.unsplash.com/photo-1583502977892-b0cecdb574fd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80",
            "https://images.unsplash.com/photo-1575451874414-edf94ed2c2b8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80",
            "https://images.unsplash.com/photo-1516836378273-db6cea41d84c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80",
            "https://images.unsplash.com/photo-1604980175453-6d6da67f914a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=788&q=80",
            "https://images.unsplash.com/photo-1603979229531-a10e06fb0e14?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1603979229623-47f11cdf2cd5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1603979229320-a1f4dc54eb00?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1603888614541-4b0a033f2fc5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80",
            "https://images.unsplash.com/photo-1603888613934-ee2f7d143dd0?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
            "https://images.unsplash.com/photo-1603888614029-4807d5c4d568?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80"
        )
    }
}