package dev.eury.coroutinesbasics.data.local

import dev.eury.coroutinesbasics.data.local.SessionManager
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.data.network.API
import retrofit2.Callback

class UserRepository {

    suspend fun getAlbums() = API.service.getAlbums(SessionManager.USER_ID)

    suspend fun getTodos() = API.service.getTodos(SessionManager.USER_ID)
}