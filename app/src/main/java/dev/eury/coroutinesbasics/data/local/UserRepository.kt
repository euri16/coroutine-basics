package dev.eury.coroutinesbasics.data.local

import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.data.network.API
import retrofit2.Callback

// TODO: refactor to use coroutines

class UserRepository {

    fun getAlbums(callback: Callback<List<Album>>) = API.service.getAlbums(SessionManager.USER_ID).enqueue(callback)

    fun getTodos(callback: Callback<List<Todo>>) = API.service.getTodos(SessionManager.USER_ID).enqueue(callback)
}