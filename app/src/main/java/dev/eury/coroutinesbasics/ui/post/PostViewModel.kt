package dev.eury.coroutinesbasics.ui.post

import androidx.lifecycle.*
import dev.eury.coroutinesbasics.data.local.PostRepository
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private val _postDataLiveData = MutableLiveData<PostScreenData>()
    val postDataLiveData: LiveData<PostScreenData> = _postDataLiveData

    private val postLiveData = MutableLiveData<Post>()
    private val commentsLiveData = MutableLiveData<List<Comment>>()

    private val _postCreateLiveData = MutableLiveData<Post>()
    val postCreateLiveData: LiveData<Post> = _postCreateLiveData

    private val postRepository = PostRepository()

    // TODO: Refactor to use coroutines
    fun fetchPostData(postId: Int) {
        postRepository.getPost(postId, object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                postLiveData.value = response.body()
                processPostResponses()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
            }
        })

        postRepository.getComments(postId, object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                commentsLiveData.value = response.body()
                processPostResponses()
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
            }
        })
    }

    private fun processPostResponses() {
        val post = postLiveData.value
        val comments = commentsLiveData.value

        if (post != null && comments != null) {
            _postDataLiveData.postValue(PostScreenData(post, comments))
        }
    }

    // TODO: Refactor to use coroutines
    fun createPost(post: Post) {
        postRepository.createPost(post, object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                _postCreateLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
            }
        })
    }
}

data class PostScreenData(val post: Post, val comments: List<Comment>)