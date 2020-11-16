package dev.eury.coroutinesbasics.data.models

data class Comment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)