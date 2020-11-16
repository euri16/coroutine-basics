package dev.eury.coroutinesbasics.ui.main.adapters

import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo

sealed class MainScreenListItem(val itemType: ItemType)
object CreatePostListItem : MainScreenListItem(ItemType.CREATE_POST)
data class TitleListItem(val title: String) : MainScreenListItem(ItemType.TITLE)
data class AlbumListItem(val albums: List<Album>) : MainScreenListItem(ItemType.ALBUM)
data class TodosListItem(val todos: List<Todo>) : MainScreenListItem(ItemType.TODOs)
data class PostsListItem(val posts: List<Post>) : MainScreenListItem(ItemType.POSTS)

enum class ItemType {
    CREATE_POST,
    TITLE,
    ALBUM,
    TODOs,
    POSTS
}