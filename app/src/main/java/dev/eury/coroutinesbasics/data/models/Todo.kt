package dev.eury.coroutinesbasics.data.models

data class Todo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)