package dev.eury.coroutinesbasics.data.models

data class Post(
    val id: Int? = null,
    val userId: Int,
    val title: String,
    val body: String
)