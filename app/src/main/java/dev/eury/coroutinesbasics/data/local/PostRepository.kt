package dev.eury.coroutinesbasics.data.local

import dev.eury.coroutinesbasics.data.local.SessionManager
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.data.network.API
import retrofit2.Callback

class PostRepository {

    suspend fun getPosts() = API.service.getPosts(SessionManager.USER_ID)

    suspend fun getPost(postId: Int) = API.service.getPost(postId)

    suspend fun createPost(post: Post) = API.service.createPost(post)

    suspend fun getComments(postId: Int) = API.service.getComments(postId)
}