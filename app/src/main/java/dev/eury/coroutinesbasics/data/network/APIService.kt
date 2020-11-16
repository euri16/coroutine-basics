package dev.eury.coroutinesbasics.data.network

import dev.eury.coroutinesbasics.data.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @GET("user/{userId}/posts")
    suspend fun getPosts(
        @Path("userId") userId: Int
    ): List<Post>

    @GET("/posts/{postId}")
    suspend fun getPost(
        @Path("postId") postId: Int
    ): Post

    @POST("posts")
    suspend fun createPost(
        @Body post: Post
    ): Post

    @GET("posts/{postId}/comments")
    suspend fun getComments(
        @Path("postId") postId: Int
    ): List<Comment>

    @GET("users/{userId}/albums")
    suspend fun getAlbums(
        @Path("userId") userId: Int
    ): List<Album>

    @GET("user/{userId}/todos")
    suspend fun getTodos(
        @Path("userId") userId: Int
    ): List<Todo>
}