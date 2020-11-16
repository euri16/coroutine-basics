package dev.eury.coroutinesbasics.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.eury.coroutinesbasics.data.local.PostRepository
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val _postDataLiveData = MutableLiveData<PostScreenData>()
    val postDataLiveData: LiveData<PostScreenData> = _postDataLiveData

    private val _postCreateLiveData = MutableLiveData<Post>()
    val postCreateLiveData: LiveData<Post> = _postCreateLiveData

    private val postRepository = PostRepository()

    fun fetchPostData(postId: Int) {
        viewModelScope.launch {
            val post = async { postRepository.getPost(postId) }
            val comments = async { postRepository.getComments(postId) }

            _postDataLiveData.postValue(PostScreenData(post.await(), comments.await()))
        }
    }

    fun createPost(post: Post) {
        viewModelScope.launch {
            val response = postRepository.createPost(post)
            _postCreateLiveData.postValue(response)
        }
    }
}

data class PostScreenData(val post: Post, val comments: List<Comment>)