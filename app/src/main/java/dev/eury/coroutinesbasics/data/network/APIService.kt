package dev.eury.coroutinesbasics.data.network

import dev.eury.coroutinesbasics.data.models.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @GET("user/{userId}/posts")
    fun getPosts(
        @Path("userId") userId: Int
    ): List<Post>

    @POST("posts")
    fun createPost(
        @Body post: Post
    ) : Post

    @GET("posts/{postId}/comments")
    fun getComments(
        @Path("postId") postId: Int
    ): List<Comment>

    @GET("albums")
    fun getAlbums(
        @Path("userId") userId: Int
    ): List<Album>

    @GET("albums/{albumId}/photos")
    fun getPhotos(
        @Path("albumId") albumId: Int
    ): List<Photo>

    @GET("user/{userId}/todos")
    fun getTodos(
        @Path("userId") userId: Int
    ): List<Todo>
}