package dev.eury.coroutinesbasics.ui.main.adapters

import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Post

sealed class MainScreenItemAction
object CreatePostClickedAction : MainScreenItemAction()
data class SeeAllAction(val itemType: ItemType) : MainScreenItemAction()
data class AlbumClickedAction(val album:Album) : MainScreenItemAction()
data class PostClickedAction(val post:Post) : MainScreenItemAction()
