package dev.eury.coroutinesbasics.data.local

import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.network.API
import retrofit2.Callback

// TODO: Refactor to use coroutines

class PostRepository {

    fun getPosts(callback: Callback<List<Post>>) = API.service.getPosts(SessionManager.USER_ID).enqueue(callback)

    fun getPost(postId: Int, callback: Callback<Post>) = API.service.getPost(postId).enqueue(callback)

    fun createPost(post: Post, callback: Callback<Post>) = API.service.createPost(post).enqueue(callback)

    fun getComments(postId: Int, callback: Callback<List<Comment>>) = API.service.getComments(postId).enqueue(callback)
}