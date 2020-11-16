package dev.eury.coroutinesbasics.ui.main

import dev.eury.coroutinesbasics.data.local.SessionManager
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.data.network.API
import retrofit2.Callback

class UserRepository {

    fun getAlbums(callback: Callback<List<Album>>) = API.service.getAlbums(SessionManager.USER_ID).enqueue(callback)

    fun getTodos(callback: Callback<List<Todo>>) = API.service.getTodos(SessionManager.USER_ID).enqueue(callback)

    fun getPosts(callback: Callback<List<Post>>) = API.service.getPosts(SessionManager.USER_ID).enqueue(callback)

    fun createPost(post:Post, callback: Callback<Post>) = API.service.createPost(post)

    fun getComments(postId:Int, callback: Callback<List<Comment>>) = API.service.getComments(postId)
}